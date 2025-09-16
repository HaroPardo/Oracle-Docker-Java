package main;

import model.User;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== LOGIN SYSTEM ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    System.out.println("\n--- USER REGISTRATION ---");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setEmail(email);
                    newUser.setPasswordHash(password);

                    if (userService.registerUser(newUser)) {
                        System.out.println("✅ User registered successfully");
                    } else {
                        System.out.println("❌ Error registering user");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LOGIN ---");
                    System.out.print("Email: ");
                    String loginEmail = scanner.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();

                    User loggedInUser = userService.validateLogin(loginEmail, loginPassword);

                    if (loggedInUser != null) {
                        System.out.println("✅ Login successful!");
                        System.out.println("Welcome: " + loggedInUser.getName());
                        System.out.println("\n--- USER PANEL ---");
                        System.out.println("ID: " + loggedInUser.getId());
                        System.out.println("Name: " + loggedInUser.getName());
                        System.out.println("Email: " + loggedInUser.getEmail());
                    } else {
                        System.out.println("❌ Invalid credentials");
                    }
                    break;

                case 3:
                    System.out.println("👋 Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid option");
            }
        }
    }
}
