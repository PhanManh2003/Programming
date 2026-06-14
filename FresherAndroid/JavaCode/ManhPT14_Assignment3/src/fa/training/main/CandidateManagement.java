package fa.training.main;

import fa.training.entities.ExperienceCandidate;
import fa.training.entities.FresherCandidate;
import fa.training.services.CandidateService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CandidateManagement {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final CandidateService candidateService = new CandidateService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CANDIDATE MANAGEMENT SYSTEM ===");
        System.out.println("This program demonstrates multi-threading with file I/O");
        System.out.println();

        // Step 1: Input candidate data from keyboard
        inputCandidates(scanner);

        // Step 2: Create and start 3 concurrent threads
        System.out.println("\n=== Starting Concurrent Threads ===\n");

        // Thread 1: Write candidates to file
        Thread writeThread = new Thread(() -> {
            candidateService.writeCandidatesToFile();
        }, "WriteThread");

        // Thread 2: Read candidates from file
        Thread readThread = new Thread(() -> {
            try {
                Thread.sleep(1500); // Wait for write to complete
                candidateService.readCandidatesFromFile();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ReadThread");

        // Thread 3: Display candidates in table format
        Thread displayThread = new Thread(() -> {
            try {
                Thread.sleep(3000); // Wait for read to complete
                candidateService.displayCandidatesInTable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "DisplayThread");

        // Start all threads
        writeThread.start();
        readThread.start();
        displayThread.start();

        // Wait for all threads to complete
        try {
            writeThread.join();
            readThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== All threads completed successfully! ===");
        scanner.close();
    }

    /**
     * Input candidates from keyboard
     */
    private static void inputCandidates(Scanner scanner) {
        System.out.println("How many candidates do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Candidate " + (i + 1) + " ---");
            System.out.println("Select candidate type:");
            System.out.println("1. Experience Candidate");
            System.out.println("2. Fresher Candidate");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                inputExperienceCandidate(scanner);
            } else if (choice == 2) {
                inputFresherCandidate(scanner);
            } else {
                System.out.println("Invalid choice! Skipping...");
                i--;
            }
        }

        System.out.println("\n" + count + " candidates added successfully!");
    }

    /**
     * Input experience candidate data
     */
    private static void inputExperienceCandidate(Scanner scanner) {
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Birth Date (dd/MM/yyyy): ");
            Date birthDate = DATE_FORMAT.parse(scanner.nextLine());

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Years of Experience: ");
            int yearsExperience = Integer.parseInt(scanner.nextLine());

            System.out.print("Professional Skill: ");
            String professionalSkill = scanner.nextLine();

            ExperienceCandidate candidate = new ExperienceCandidate(
                    firstName, lastName, birthDate, address, phone, email,
                    yearsExperience, professionalSkill
            );

            candidateService.addCandidate(candidate);
            System.out.println("Experience candidate added successfully!");

        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        }
    }

    /**
     * Input fresher candidate data
     */
    private static void inputFresherCandidate(Scanner scanner) {
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Birth Date (dd/MM/yyyy): ");
            Date birthDate = DATE_FORMAT.parse(scanner.nextLine());

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Graduation Date (dd/MM/yyyy): ");
            Date graduationDate = DATE_FORMAT.parse(scanner.nextLine());

            System.out.print("Graduation Rank (Excellent/Good/Fair/Poor): ");
            String graduationRank = scanner.nextLine();

            System.out.print("Education (University name): ");
            String education = scanner.nextLine();

            FresherCandidate candidate = new FresherCandidate(
                    firstName, lastName, birthDate, address, phone, email,
                    graduationDate, graduationRank, education
            );

            candidateService.addCandidate(candidate);
            System.out.println("Fresher candidate added successfully!");

        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd/MM/yyyy");
        }
    }
}
