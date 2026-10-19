/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart2;
import java.util.Scanner;
/**
 *
 * @author Student
 */

public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private boolean registered = false;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean upper = false;
        boolean digit = false;
        boolean special = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }

        return upper && digit && special;
    }

    public boolean checkCellPhoneNumber(String number) {
        return number.matches("\\+27[0-9]{9}");
    }

    public String registerUser(Scanner input) {
        System.out.println("\n--- REGISTRATION ---");

        System.out.print("Enter username: ");
        username = input.nextLine();

        if (!checkUserName(username)) {
            return "Username is not correctly formatted. "
                    + "It must contain an underscore and be no more than 5 characters.";
        }

        System.out.print("Enter password: ");
        password = input.nextLine();

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. "
                    + "It must have at least 8 characters, a capital letter, "
                    + "a number and a special character.";
        }

        System.out.print("Enter cellphone number (+27XXXXXXXXX): ");
        cellPhoneNumber = input.nextLine();

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cellphone number is incorrectly formatted. "
                    + "Use the South African international format, e.g. +27821234567.";
        }

        registered = true;
        return "Registration successful!";
    }

    public boolean loginUser(Scanner input) {
        if (!registered) {
            System.out.println("Please register first.");
            return false;
        }

        System.out.println("\n--- LOGIN ---");

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome back! It is great to see you again.";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }
}
