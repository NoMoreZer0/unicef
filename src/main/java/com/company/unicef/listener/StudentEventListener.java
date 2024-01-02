package com.company.unicef.listener;

import com.company.unicef.entity.Student;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentEventListener {

    @Autowired
    DataManager dataManager;

    @Autowired
    protected NotificationManager notificationManager;
    @EventListener
    public void onStudentSaving(final EntitySavingEvent<Student> event) {
        if(event.isNewEntity()) {
            List<User> userNotifications = loadByRole();
            List<String> usernamesNotific = new ArrayList<>();
            for (User user : userNotifications) {
                usernamesNotific.add(user.getUsername());
            }
            notificationManager.createNotification()
                    .withSubject("Добавлен новый студент")
                    .withRecipientUsernames(usernamesNotific)
                    .toChannelsByNames("in-app")
                    .withContentType(ContentType.PLAIN)
                    .withBody("Проведите проверку нового студента: "+event.getEntity().getFio())
                    .send();
        }
    }

    public List<User> loadByRole() {
        return dataManager.load(User.class)
                .query("select u from User u where u.role = :role1 or u.role = :role2")
                .parameter("role1", "кейс-менеджер")
                .parameter("role2", "школьный администратор")
                .list();
    }
}