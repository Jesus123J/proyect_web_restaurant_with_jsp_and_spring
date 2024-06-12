package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.service.EmailService;
import com.proyect.racoonbrothers.service.ISendPasswordEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService, ISendPasswordEmail {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendOtpEmail(String email, String otpGenerated) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Verify Account");
            mimeMessageHelper.setText(String.format(
                    "<div style=\"background-color: #f5f5f5; padding: 20px; border-radius: 5px;\">\n" +
                            "<h2>Código de un solo uso:</h2>\n" +
                            "<p style=\"font-size: 20px; font-weight: bold; text-align: center;\">%s</p>\n" +
                            "<p>Haga clic en el botón a continuación para verificar su cuenta.</p>\n" +
                            "<a href=\"http://localhost:8081/auth/verify-account?email=%s&otp=%s\" style=\"background-color: #4CAF50; color: white; padding: 10px 20px; text-align: center; text-decoration: none; display: block; font-size: 16px; margin-top: 10px;\">Verify Account</a>\n" +
                            "</div>"
                    , otpGenerated, email, otpGenerated), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al enviar el correo");
        }
    }

    @Override
    public void sendPasswordEmail(String email, String password) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Racoon Brothers: New Account");
            mimeMessageHelper.setText(String.format(
                    "<div style=\"background-color: #f5f5f5; padding: 20px; border-radius: 5px;\">\n" +
                            "<h2>Contraseña de su nueva cuenta en el restaurante:\"Racoon Brothers\"</h2>\n" +
                            "<p style=\"font-size: 20px; font-weight: bold; text-align: center;\">%s</p>\n" +
                            "</div>"
                    , password, email), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al enviar el correo de enviar contraseña");
        }
    }

}
