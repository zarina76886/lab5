package registration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationManager manager = new RegistrationManager();
        boolean running = true;

        System.out.println("=== Event Registration System ===");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add registration");
            System.out.println("2. Show all registrations");
            System.out.println("3. Find registration by ID");
            System.out.println("4. Delete registration by ID");
            System.out.println("5. Show registrations for an event");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Ввод имени
                    System.out.print("Full name: ");
                    String name = scanner.nextLine();
                    if (!Registration.isValidFullName(name)) {
                        System.out.println("Rejected: Full name must be at least 3 characters long.");
                        break;
                    }

                    // Ввод email
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (!Registration.isValidEmail(email)) {
                        System.out.println("Rejected: Invalid email format (must contain @ with text before and after).");
                        break;
                    }

                    // Ввод группы
                    System.out.print("Student group: ");
                    String group = scanner.nextLine();
                    if (!Registration.isValidGroup(group)) {
                        System.out.println("Rejected: Student group cannot be blank.");
                        break;
                    }

                    // Выбор ивента
                    System.out.println("Select event:");
                    System.out.println("1. Web Design Workshop");
                    System.out.println("2. JavaScript Quiz");
                    System.out.println("3. IT Career Talk");
                    System.out.print("Event choice (1-3): ");

                    int eventChoice;
                    try {
                        eventChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Rejected: Event choice must be a number between 1 and 3.");
                        break;
                    }

                    if (!Registration.isValidEvent(eventChoice)) {
                        System.out.println("Rejected: Invalid event choice. Must be 1, 2, or 3.");
                        break;
                    }

                    manager.addRegistration(name, email, group, eventChoice);
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.findById(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ID must be a number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.deleteById(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ID must be a number.");
                    }
                    break;

                case 5:
                    System.out.println("Select event to filter:");
                    System.out.println("1. Web Design Workshop");
                    System.out.println("2. JavaScript Quiz");
                    System.out.println("3. IT Career Talk");
                    System.out.print("Event choice (1-3): ");
                    try {
                        eventChoice = Integer.parseInt(scanner.nextLine());
                        if (Registration.isValidEvent(eventChoice)) {
                            manager.displayByEvent(eventChoice);
                        } else {
                            System.out.println("Invalid event choice.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a number between 1 and 3.");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown option. Choose between 0 and 5.");
            }
        }
        scanner.close();
    }
}