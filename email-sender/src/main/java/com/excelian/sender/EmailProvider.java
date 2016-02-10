package com.excelian.sender;

import com.excelian.domain.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailProvider {

    private String smtpAddress;
    private String smtpPort;
    private String login;
    private String password;

    private EmailProvider(String smtpAddress, String smtpPort, String login, String password) {
        this.smtpAddress = smtpAddress;
        this.smtpPort = smtpPort;
        this.login = login;
        this.password = password;
    }

    public static EmailProvider newInstance(String smtpAddress, String smtpPort, String login, String password) {
        return new EmailProvider(smtpAddress, smtpPort, login, password);
    }

    public EmailProvider send(Email email) throws MessagingException {
        Session mailSession = Session.getDefaultInstance(getMailServerProperties(), null);
        Message message = getMailMessage(mailSession, email);
        sendMessage(mailSession, message);

        return this;
    }

    protected Properties getMailServerProperties() {
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.host", smtpAddress);
        mailServerProperties.put("mail.smtp.port", smtpPort);
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        return mailServerProperties;
    }

    protected Message getMailMessage(Session session, Email email) throws MessagingException {
        Message mailMessage = new MimeMessage(session);
        mailMessage.setFrom(new InternetAddress(email.getSender()));
        for (String recipient : email.getRecipients()) {
            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }
        mailMessage.setSubject(email.getSubject());
        mailMessage.setContent(email.getBody(), "text/html");
        return mailMessage;
    }

    public void sendMessage(Session session, Message message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(smtpAddress, login, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

}
