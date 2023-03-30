package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.NotifyRepository;
import swag.rest.nis_risk_app.dao.UserRepository;
import swag.rest.nis_risk_app.entity.Email;
import swag.rest.nis_risk_app.entity.Notification;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.service.NotificationService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotifyRepository notifyRepository;

    private final JavaMailSender mailSender;

    private final UserRepository userRepository;


    @Override
    @Transactional
    public List<Notification> getNotification(String username) throws MessagingException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with this username not found"));
        List<Notification> notifications = notifyRepository.findAllById(Collections.singleton(user.getId()));
        sendEmailWithAttachment(new Email(user.getEmail()));
        return notifications;
    }

    @Override
    @Transactional
    public void sendEmailWithAttachment(Email toEmail) throws MessagingException {

        String body = "This email has attachment";
        String subject = "This is Email Body with Attachment...";

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
        mimeMessageHelper.setTo(toEmail.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");
    }
}
