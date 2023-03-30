package swag.rest.nis_risk_app.service;

import swag.rest.nis_risk_app.entity.Email;
import swag.rest.nis_risk_app.entity.Notification;

import javax.mail.MessagingException;
import java.util.List;

public interface NotificationService {

    List<Notification> getNotification(String username) throws MessagingException;

    void sendEmailWithAttachment(Email toEmail) throws MessagingException;
}
