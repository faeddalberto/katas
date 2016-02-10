package com.excelian.sender;

import com.excelian.domain.Email;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class EmailProviderTest {

    @Resource
    EmailProvider emailProvider;

    private GreenMail greenMail;
    private Session NOT_USED_SESSION = null;

    @Before
    public void startMailServer() {
        greenMail = new GreenMail(ServerSetupTest.SMTP);
        greenMail.start();
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }

    @Test
    public void shouldSetMailServerProperties() {
        emailProvider = EmailProvider.newInstance("localhost", "3025", "username", "password");
        Properties props = emailProvider.getMailServerProperties();
        assertEquals("localhost", props.get("mail.smtp.host"));
        assertEquals("3025", props.get("mail.smtp.port"));
        assertEquals("true", props.get("mail.smtp.auth"));
        assertEquals("true", props.get("mail.smtp.starttls.enable"));
    }


    @Test
    public void shouldSetMailMessage() throws MessagingException, IOException {
        emailProvider = EmailProvider.newInstance("localhost", "3025", "username", "password");
        Message message = emailProvider.getMailMessage(
                NOT_USED_SESSION,
                new Email("sender@email.com", Collections.singleton("recipient@email.com"), "Subject", "Body"));

        Address[] recipients = message.getAllRecipients();
        assertEquals(1, recipients.length);
        Address address = recipients[0];
        assertEquals("recipient@email.com", address.toString());
        assertEquals("Subject", message.getSubject());
        assertEquals("Body", message.getContent().toString().trim());
    }

    @Test
    public void shouldSendEmailSuccessfully() throws MessagingException, IOException {
        Email email = new Email("from@localhost.com", Collections.singleton("to@localhost.com"), "Test Subject", "test body");
        emailProvider = EmailProvider
            .newInstance("localhost", "3025", "username", "password")
            .send(email);

        MimeMessage[] emails = greenMail.getReceivedMessages();
        assertEquals(1, emails.length);

        MimeMessage message = emails[0];
        assertEquals("from@localhost.com", message.getFrom()[0].toString());
        assertEquals("to@localhost.com", message.getRecipients(Message.RecipientType.TO)[0].toString());
        assertEquals("Test Subject", message.getSubject());
        assertEquals("test body", message.getContent().toString().trim());

    }
}
