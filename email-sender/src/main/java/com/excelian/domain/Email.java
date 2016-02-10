package com.excelian.domain;

import com.google.common.base.Objects;

import java.util.HashSet;
import java.util.Set;

public class Email {

    private String sender;
    private Set<String> recipients;

    private String subject;
    private String body;
    private Set<Object> attachments;

    public Email(String sender, Set<String> recipients, String subject, String body) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.attachments = new HashSet<Object>() {
        };
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    public void addAttachment(Object attachment) {
        attachments.add(attachment);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Object> attachments) {
        this.attachments = attachments;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("sender", sender)
                .add("recipients", recipients)
                .add("subject", subject)
                .add("body", body)
                .add("attachments", attachments)
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email that = (Email) o;

        return Objects.equal(this.sender, that.sender) &&
                Objects.equal(this.recipients, that.recipients) &&
                Objects.equal(this.subject, that.subject) &&
                Objects.equal(this.body, that.body) &&
                Objects.equal(this.attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sender, recipients, subject, body, attachments);
    }
}
