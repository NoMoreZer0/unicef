package com.company.unicef.app;

import com.company.unicef.entity.Event;
import com.company.unicef.entity.EventDate;
import com.company.unicef.entity.EventUser;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.FetchPlan;
import io.jmix.core.security.Authenticated;
import io.jmix.email.EmailException;
import io.jmix.email.EmailInfo;
import io.jmix.email.EmailInfoBuilder;
import io.jmix.email.Emailer;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.entity.ContentType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class MissedEventDateMeetingServiceNotification implements Job {

    @Autowired
    private Emailer emailer;

    @Autowired
    NotificationManager notificationManager;


    @Autowired
    private DataManager dataManager;
    @Authenticated
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            sendNotificationByEmailAboutMissedDate();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendNotificationByEmailAboutMissedDate() throws EmailException, IOException {
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        System.out.println("currentDate: " + currentDate);
        LocalDateTime fourDaysBefore = currentDate.minusDays(3);
        System.out.printf("fourDaysBefore: " + fourDaysBefore);

        List<EventDate> eventDates = dataManager.load(EventDate.class)
                .query("select e from EventDate e where e.eventDate <= :currentDate and e.eventDate >= :fourDaysBefore")
                .parameter("currentDate", currentDate)
                .parameter("fourDaysBefore", fourDaysBefore)
                .fetchPlan(FetchPlan.BASE)
                .list();

        //print eventDates
        System.out.println("eventDates Before: " + eventDates);
        //check if eventDates is null or empty and check if eventDates are 24 hours, 48 hours or 72 hours before meeting and if they are send that meeting is in 24 hours, 48 hours or 72 hours

        if (eventDates == null || eventDates.isEmpty()) {
            System.out.println("eventDates is null or empty");
        } else {
            for (EventDate eventDate : eventDates) {
                //check if private Boolean hasHappened = false or null of eventDate
                Boolean hasHappened = eventDate.getHasHappened();
                if (hasHappened == false || hasHappened == null) {
                    sendEmailNotification(eventDate);
                }

            }
        }


    }

    @Authenticated
    private void sendEmailNotification(EventDate eventDate) throws EmailException, IOException {

        Event event = dataManager.load(Event.class)
                .query("select e from Event e where e.id = :eventId")
                .parameter("eventId", eventDate.getEvent().getId())
                .fetchPlan(FetchPlan.BASE)
                .one();
        //replace all sout to logging
        System.out.println("event: " + event);

        List<EventUser> eventUsers = dataManager.load(EventUser.class)
                .query("select e from EventUser e where e.event.id = :eventId")
                .parameter("eventId", event.getId())
                .fetchPlan(FetchPlan.BASE)
                .list();
        System.out.println("eventUsers: " + eventUsers);

        //get user emails from eventUsers based on user id
        List<UUID> userIds = eventUsers.stream()
                .map(EventUser::getUser)
                .map(User::getId)
                .collect(toList());
        System.out.println("userIds: " + userIds);

        //get list of users  based of userIds through dataManager query
        List<User> users = dataManager.load(User.class)
                .query("select u from User u where u.id in :userIds")
                .parameter("userIds", userIds)
                .fetchPlan(FetchPlan.BASE)
                .list();
        System.out.println("users: " + users);

        //get list of emails from users enitites
        List<String> emailList = users.stream()
                .map(User::getEmail)
                .collect(toList());

        System.out.println("emailList: " + emailList);


        for (String email : emailList) {
            if (email == null || email.isEmpty() || !email.contains("@")) {
                System.out.println("email: " + email);
                emailList.remove(email);
                // log about what happened
                System.out.println("email: " + email + " was removed");
                //log email that was removed
                System.out.println("email: " + email + " was removed");
            }
        }

        for (String email : emailList) {
            sendByEmailInfo(email, eventDate, users);
        }

    }

    @Authenticated
    private void sendByEmailInfo(String address, EventDate date,List<User> users) throws EmailException {
        String subject = "Кездесу туралы еске салғыш/Event Reminder /Напоминание о Встрече";

        LocalDateTime eventDate = date.getEventDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedEventDate = eventDate.format(formatter);

        String body = "Шара өткізілмеді. Құрметті қызметкер, Сізге " + date.getName() + " деп аталатын жіберілген шарадан хабардар етеміз, ол " + formattedEventDate + " күні белгіленген болатын. Күнін қайта белгілеу үшін порталды ашып, хабарландыру бөлімін қараңыз.\n"+
                "\nAn event has been missed. Dear employee, we remind you of the missed event " + date.getName() + ", which was scheduled for " + formattedEventDate + ". To reschedule, please open the open the site and visit notifications.\n"+
                "\nМероприятие было пропущено. Уважаемый сотрудник, напоминаем вам о пропущенном мероприятии " + date.getName() + ", которое было назначено на " + formattedEventDate + ",чтобы  переназначить дату откройте портал и посетите раздел уведомлений.\n";

        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(address)
                .setSubject(subject)
                .setFrom(null)
                .setBody(body)
                .build();
        emailer.sendEmail(emailInfo);

        List<String> usernamesNotific = users.stream()
                .map(User::getUsername)
                .collect(toList());

        System.out.printf("usernamesNotific: " + usernamesNotific);

        notificationManager.createNotification()
                .withSubject("Шара өткізілмеді/An event has been missed/Пропущено мероприятие")
                .withRecipientUsernames(usernamesNotific)
                .toChannelsByNames("in-app")
                .withContentType(ContentType.PLAIN)
                .withBody(String.format("Поменяйте дату мероприятия/Reschedule the event/Шара күнін өзгертіңіз %s", date.getName()))
                .send();
    }



}