package com.company.unicef;

import com.company.unicef.app.EmailNotificationForEventDates;
import com.company.unicef.app.MissedEventDateMeetingServiceNotification;
import com.google.common.base.Strings;
import io.jmix.notifications.NotificationType;
import io.jmix.notifications.NotificationTypesRepository;
import org.quartz.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
public class UnicefApplication {

    @Autowired
    private Environment environment;

    @Autowired
    private NotificationTypesRepository notificationTypesRepository;

    public static void main(String[] args) {
        SpringApplication.run(UnicefApplication.class, args);
    }

    @Bean
    @Primary
    @ConfigurationProperties("main.datasource")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("main.datasource.hikari")
    DataSource dataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @EventListener
    public void printApplicationUrl(ApplicationStartedEvent event) {
        LoggerFactory.getLogger(UnicefApplication.class).info("Application started at "
                + "http://localhost:"
                + environment.getProperty("local.server.port")
                + Strings.nullToEmpty(environment.getProperty("server.servlet.context-path")));
    }

    @Bean
    JobDetail myCustomEmailSendingJob() {
        return JobBuilder.newJob()
                .ofType(EmailNotificationForEventDates.class)
                .storeDurably()
                .withIdentity("NotificationBeforeEvent")
                .build();
    }

    @Bean
    Trigger MyCustomEmailSendingTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(myCustomEmailSendingJob())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?"))
                .build();
    }

    @Bean
    JobDetail missedDatesCustomEmailSendingJob() {
        return JobBuilder.newJob()
                .ofType(MissedEventDateMeetingServiceNotification.class)
                .storeDurably()
                .withIdentity("MissedDateRuntime")
                .build();
    }

    @Bean
    Trigger missedDateEmailSendingTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(missedDatesCustomEmailSendingJob())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?"))
                .build();
    }


    @PostConstruct
    public void postConstruct() {
        notificationTypesRepository.registerTypes(
                new NotificationType("info", "INFO_CIRCLE"),
                new NotificationType("warn", "WARNING"),
                new NotificationType("StudentCreated","INFO")
        );
    }
}
