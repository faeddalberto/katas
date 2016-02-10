package com.excelian.starter;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CmdStarterTest {

    @Test
    public void whenParametersArePassedCorrectly_gettersShouldReturnExpectedValues() {
        CmdStarter starter = new CmdStarter
                .Builder("server.domain.com", "587", "from@email.com", "p4$$w0rD")
                .withRecipient("to@email.com")
                .withSubject("Test subject")
                .withBody("Test body")
                .build();

        assertEquals("server.domain.com", starter.getSmtpServer());
        assertEquals("587", starter.getSmtpPort());
        assertEquals("from@email.com", starter.getSenderEmail());
        assertEquals("p4$$w0rD", starter.getSenderPassword());
        assertTrue(starter.getRecipients().size() == 1);
        assertTrue(starter.getRecipients().contains("to@email.com"));
        assertEquals("Test subject", starter.getSubject());
        assertEquals("Test body", starter.getBody());
    }
}
