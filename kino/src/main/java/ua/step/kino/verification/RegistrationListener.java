package ua.step.kino.verification;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import ua.step.kino.entities.User;
import ua.step.kino.services.RegistrationService;

@Component
public class RegistrationListener implements ApplicationListener <OnRegistrationCompleteEvent> {
  
    @Autowired
    private RegistrationService registrationService;
  
    @Autowired
    private JavaMailSender mailSender;
 
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
 
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        registrationService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String recipientName = user.getName();
        String subject = "Registration confirmation";
        String confirmationUrl 
          = "http://localhost:8080/login/registrationConfirm?token=" + token;       
        
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText("Almost done, " + recipientName + "! To complete your Kinoshara sign up, we just need to verify your email address: " + confirmationUrl);
        
        mailSender.send(email);
    }
}
