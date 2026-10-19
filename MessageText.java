
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart2;
/**
 *
 * @author Student
 */
public class MessageText {

    public static void main(String[] args) {

        System.out.println("===== QUICKCHAT MESSAGE TESTS =====");

        // Test 1: Message ID
        Message message1 = new Message(
                "+27812345678",
                "Hi Mike, can you join us tonight?"
        );

        System.out.println("\nTest 1: Message ID");
        if (message1.checkMessageID()) {
            System.out.println("PASS: Message ID is valid.");
        } else {
            System.out.println("FAIL: Message ID is invalid.");
        }

        // Test 2: Correct recipient cell number
        System.out.println("\nTest 2: Valid recipient number");
        if (message1.checkRecipientCell()) {
            System.out.println("PASS: Cell phone number successfully captured.");
        } else {
            System.out.println("FAIL: Cell phone number is incorrectly formatted.");
        }

        // Test 3: Incorrect recipient cell number
        Message message2 = new Message(
                "0812345678",
                "This is a test message."
        );

        System.out.println("\nTest 3: Invalid recipient number");
        if (!message2.checkRecipientCell()) {
            System.out.println("PASS: Invalid recipient number rejected.");
        } else {
            System.out.println("FAIL: Invalid recipient number accepted.");
        }

        // Test 4: Message hash
        System.out.println("\nTest 4: Message hash");
        String hash = message1.createMessageHash();

        System.out.println("Generated message hash: " + hash);

        if (hash != null && !hash.isEmpty()) {
            System.out.println("PASS: Message hash created.");
        } else {
            System.out.println("FAIL: Message hash was not created.");
        }

        // Test 5: Send a message
        System.out.println("\nTest 5: Send message");
        String result = message1.sendMessage();

        if (result.equals("Message successfully sent.")) {
            System.out.println("PASS: Message sent successfully.");
        } else {
            System.out.println("FAIL: Message could not be sent.");
        }

        // Test 6: Total messages sent
        System.out.println("\nTest 6: Total messages sent");
        int total = Message.returnTotalMessages();

        System.out.println("Total messages sent: " + total);

        if (total == 1) {
            System.out.println("PASS: Total messages counted correctly.");
        } else {
            System.out.println("FAIL: Total messages counted incorrectly.");
        }

        // Test 7: Message details
        System.out.println("\nTest 7: Display message details");
        System.out.println(message1.printMessages());

        System.out.println("\n===== TESTS COMPLETED =====");
    }
}

