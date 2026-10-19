package com.mycompany.poepart2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Message {

    private static int messageCount = 0;
    private static final List<Message> sentMessages = new ArrayList<>();

    private final String messageID;
    private final String recipient;
    private final String messageText;
    private final String messageHash;

    public Message(String recipient, String messageText) {
        messageCount++;

        this.messageID = String.format("%010d",
                new Random().nextInt(1_000_000_000));

        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public boolean checkRecipientCell() {
        return recipient.matches("\\+27[0-9]{9}");
    }

    public String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");

        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0
                ? words[words.length - 1] : "";

        return messageID.substring(0, 2) + ":"
                + messageCount + ":"
                + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public String sendMessage() {
        sentMessages.add(this);
        return "Message successfully sent.";
    }

    public String printMessages() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    public static List<Message> getSentMessages() {
        return sentMessages;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
