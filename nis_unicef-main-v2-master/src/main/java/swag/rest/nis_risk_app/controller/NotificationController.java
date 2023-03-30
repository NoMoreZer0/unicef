package swag.rest.nis_risk_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import swag.rest.nis_risk_app.entity.Notification;
import swag.rest.nis_risk_app.service.NotificationService;

import javax.mail.MessagingException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/get_notification_/{username}")
    public List<Notification> getNotification(@PathVariable("username") String username) throws MessagingException {
        return notificationService.getNotification(username);
    }


}
