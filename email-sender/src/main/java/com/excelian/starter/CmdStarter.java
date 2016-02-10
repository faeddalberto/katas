package com.excelian.starter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.excelian.domain.Email;
import com.excelian.sender.EmailProvider;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Set;

public class CmdStarter {

    @Parameter(names = "-recipient", description = "Email recipients list", required = true)
    private Set<String> recipients;

    @Parameter(names = "-smtp_server")
    private String smtpServer;

    @Parameter(names = "-smtp_port")
    private String smtpPort;

    @Parameter(names = "-sender_email")
    private String senderEmail;

    @Parameter(names = "-sender_password")
    private String senderPassword;

    @Parameter(names = "-email_subject")
    private String subject;

    @Parameter(names = "-email_body")
    private String body;

    private CmdStarter() {}

    private CmdStarter(
            String smtpServer,
            String smtpPort,
            String senderEmail,
            String senderPassword,
            Set<String> recipients,
            String subject,
            String body) {
        this.smtpServer = smtpServer;
        this.smtpPort = smtpPort;
        this.senderEmail = senderEmail;
        this.senderPassword = senderPassword;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
    }

    public static void main(String[] args) throws MessagingException {
        CmdStarter starter = new CmdStarter();
        new JCommander(args);

        starter.sendEmail(new Email(starter.senderEmail, starter.recipients, starter.subject, starter.body));
    }

    public void sendEmail(Email email) throws MessagingException {
        EmailProvider
                .newInstance(smtpServer, smtpPort, senderEmail, senderPassword)
                .send(email);
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {

        private String smtpServer;
        private String smtpPort;
        private String senderEmail;
        private String senderPassword;
        private Set<String> recipients;
        private String subject;
        private String body;

        public Builder( String smtpServer,
                        String smtpPort,
                        String senderEmail,
                        String senderPassword) {
            this.smtpServer = smtpServer;
            this.smtpPort = smtpPort;
            this.senderEmail = senderEmail;
            this.senderPassword = senderPassword;
            this.recipients = new HashSet<String>();
        }
        
        public Builder withSmtpServer(String smtpServer) {
            this.smtpServer = smtpServer;
            return this;
        }

        public Builder withSmtpPort(String smtpPort) {
            this.smtpPort = smtpPort;
            return this;
        }

        public Builder withSenderEmail(String senderEmail) {
            this.senderEmail = senderEmail;
            return this;
        }

        public Builder withSenderPassword(String senderPassword) {
            this.senderPassword = senderPassword;
            return this;
        }

        public Builder withRecipients(Set<String> recipients) {
            this.recipients.addAll(recipients);
            return this;
        }

        public Builder withRecipient(String recipient) {
            this.recipients.add(recipient);
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public CmdStarter build() {
            return new CmdStarter(smtpServer, smtpPort, senderEmail, senderPassword, recipients, subject, body);
        }
    }
}
