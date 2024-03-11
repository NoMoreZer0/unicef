package com.company.unicef.app;

import com.company.unicef.entity.Event;
import com.company.unicef.entity.EventDate;
import com.company.unicef.entity.EventUser;
import com.company.unicef.entity.User;

import io.jmix.core.DataManager;
import io.jmix.core.FetchPlan;
import io.jmix.core.security.Authenticated;
import io.jmix.email.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jmix.email.EmailInfo;
import io.jmix.email.EmailInfoBuilder;
import io.jmix.email.Emailer;
import org.checkerframework.checker.units.qual.A;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;



import static java.util.stream.Collectors.*;


@Component
public class EmailNotificationForEventDates implements Job {

    @Autowired
    private Emailer emailer;

    @Autowired
    private DataManager dataManager;

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationForEventDates.class);

    @Authenticated
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            sendNotificationByEmail();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendNotificationByEmail() throws EmailException, IOException {
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        log.info("currentDate: " + currentDate);
        LocalDateTime fourDaysAhead = currentDate.plusDays(3);
        log.info("fourDaysAhead: " + fourDaysAhead);
        int threeDaysBeforeMeeting = 3;
        int twoDaysBeforeMeeting = 2;
        int oneDayBeforeMeeting = 1;

        List<EventDate> eventDates = dataManager.load(EventDate.class)
                .query("select e from EventDate e where e.eventDate >= :currentDate and e.eventDate <= :fourDaysAhead")
                .parameter("currentDate", currentDate)
                .parameter("fourDaysAhead", fourDaysAhead)
                .fetchPlan(FetchPlan.BASE)
                .list();

        //print eventDates
        log.info("eventDates: " + eventDates);
        //check if eventDates is null or empty and check if eventDates are 24 hours, 48 hours or 72 hours before meeting and if they are send that meeting is in 24 hours, 48 hours or 72 hours

        if (eventDates == null || eventDates.isEmpty()) {
            log.info("eventDates is null or empty");
        } else {
            for (EventDate eventDate : eventDates) {
                LocalDateTime roundedEventDate = eventDate.getEventDate();
                long daysDifference = ChronoUnit.DAYS.between(currentDate, roundedEventDate);
                log.info("daysDifference: " + daysDifference);
                //here check for threeDaysBeforeMeeting, twoDaysBeforeMeeting and oneDayBeforeMeeting
                if (daysDifference == threeDaysBeforeMeeting) {
                    String threeDaysLeft = "3";
                    sendEmailNotification(eventDate, threeDaysLeft);
                } else if (daysDifference == twoDaysBeforeMeeting) {
                    String twoDaysLeft = "2";
                    sendEmailNotification(eventDate, twoDaysLeft);
                } else if (daysDifference == oneDayBeforeMeeting) {
                    String oneDayLeft = "1";
                    sendEmailNotification(eventDate, oneDayLeft);
                }
            }
        }


    }

    @Authenticated
    private void sendEmailNotification(EventDate eventDate, String daysDifference) throws EmailException, IOException {

        Event event = dataManager.load(Event.class)
                .query("select e from Event e where e.id = :eventId")
                .parameter("eventId", eventDate.getEvent().getId())
                .fetchPlan(FetchPlan.BASE)
                .one();
        //replace all sout to logging
        log.info("event: " + event);

        List<EventUser> eventUsers = dataManager.load(EventUser.class)
                .query("select e from EventUser e where e.event.id = :eventId")
                .parameter("eventId", event.getId())
                .fetchPlan(FetchPlan.BASE)
                .list();
        log.info("eventUsers: " + eventUsers);

        //get user emails from eventUsers based on user id
        List<UUID> userIds = eventUsers.stream()
                .map(EventUser::getUser)
                .map(User::getId)
                .collect(toList());
        log.info("userIds: " + userIds);

        //get list of users  based of userIds through dataManager query
        List<User> users = dataManager.load(User.class)
                .query("select u from User u where u.id in :userIds")
                .parameter("userIds", userIds)
                .fetchPlan(FetchPlan.BASE)
                .list();
        log.info("users: " + users);

        //get list of emails from users enitites
        List<String> emailList = users.stream()
                .map(User::getEmail)
                .collect(toList());
        log.info("emailList: " + emailList);

        //get emails from parents from event entity
        List<String> parentEmails = event.getParents().stream()
                .map(com.company.unicef.entity.Parent::getEmail)
                .collect(toList());
        log.info("parentEmails: " + parentEmails);

        //add parentEmails to emailList
        emailList.addAll(parentEmails);
        log.info("emailList: " + emailList);


        String message = daysDifference;

        for (String email : emailList) {
            if (email == null || email.isEmpty() || !email.contains("@")) {
                log.info("email: " + email);
                emailList.remove(email);
                // log about what happened
                log.info("email: " + email + " was removed");
                //log email that was removed
                log.info("email: " + email + " was removed");
            }
        }

        for (String email : emailList) {
            sendByEmailInfo(email, message, eventDate);
        }

}

    @Authenticated
    private void sendByEmailInfo(String address, String message, EventDate date) throws EmailException {
        String subject = "Напоминание о Встрече / Event Reminder /Кездесу туралы еске салғыш";

        LocalDateTime eventDate = date.getEventDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedEventDate = eventDate.format(formatter);

        String body = "До мероприятия осталось " + message + " дня. Уважаемые родители и сотрудники, напоминаем вам о мероприятии " + date.getName() + ", которое назначено на " + formattedEventDate + ".\n"
                + "There is " + message + " day left before the event. Dear parents and staff, we remind you about the event on " + date.getName() + ", which is scheduled for " + formattedEventDate + ".\n"
                + "Іс-шараға " + message + " күн қалды. Құрметті ата-аналар мен ұжым " + date.getName() + " жоспарланған " + formattedEventDate + " күні өтетін іс-шараны еске саламыз.";


        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(address)
                .setSubject(subject)
                .setFrom(null)
                .setBody(body)
                .build();
        emailer.sendEmail(emailInfo);
    }

}
