/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart2;

import java.util.Scanner;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class Poepart2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("================================");
        System.out.println("       WELCOME TO QUICKCHAT");
        System.out.println("================================");

        // Registration
        String registrationMessage = login.registerUser(input);
        System.out.println(registrationMessage);

        if (!registrationMessage.equals("Registration successful!")) {
            System.out.println("Please restart the program and register again.");
            input.close();
            return;
        }

        // Login
        boolean loggedIn = login.loginUser(input);
        System.out.println(login.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            input.close();
            return;
        }

        // QuickChat menu
        boolean running = true;

        while (running) {
            System.out.println("\n========== QUICKCHAT MENU ==========");
            System.out.println("1. Send a message");
            System.out.println("2. View sent messages");
            System.out.println("3. Display total messages sent");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter recipient number (+27XXXXXXXXX): ");
                    String recipient = input.nextLine();

                    Message messageCheck = new Message(recipient, "");

                    if (!messageCheck.checkRecipientCell()) {
                        System.out.println("Invalid recipient number.");
                        break;
                    }

                    System.out.print("Enter your message (maximum 250 characters): ");
                    String messageText = input.nextLine();

                    if (messageText.isEmpty() || messageText.length() > 250) {
                        System.out.println(
                                "Message cannot be empty or exceed 250 characters.");
                        break;
                    }

                    Message message = new Message(recipient, messageText);

                    System.out.println(message.sendMessage());
                    System.out.println(message.printMessages());
                    break;

                case "2":
                    if (Message.getSentMessages().isEmpty()) {
                        System.out.println("No messages have been sent yet.");
                    } else {
                        for (Message sent : Message.getSentMessages()) {
                            System.out.println("\n" + sent.printMessages());
                        }
                    }
                    break;

                case "3":
                    System.out.println("Total messages sent: "
                            + Message.returnTotalMessages());
                    break;

                case "4":
                    running = false;
                    System.out.println("Thank you for using QuickChat!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3 or 4.");
            }
        }

        input.close();
    }
}
