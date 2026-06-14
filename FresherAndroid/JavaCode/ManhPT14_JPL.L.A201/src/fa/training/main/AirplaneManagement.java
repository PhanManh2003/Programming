package fa.training.main;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.services.AirportService;
import fa.training.services.FixedwingService;
import fa.training.services.HelicopterService;
import fa.training.utils.Validation;
import fa.training.utils.ValidationException;
import java.util.List;
import java.util.Scanner;

public class AirplaneManagement {

    private static Scanner scanner = new Scanner(System.in);
    private static AirportService airportService = new AirportService();
    private static FixedwingService fixedwingService = new FixedwingService();
    private static HelicopterService helicopterService = new HelicopterService();

    public static void main(String[] args) {
        // load data
        fixedwingService.loadFromFile();
        helicopterService.loadFromFile();
        airportService.loadFromFile();
        
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println("       AIRPLANE MANAGEMENT SYSTEM       ");
            System.out.println("========================================");
            System.out.println("1. Input data from keyboard");
            System.out.println("2. Airport management");
            System.out.println("3. Fixed wing airplane management");
            System.out.println("4. Helicopter management group");
            System.out.println("0. Close program");
            System.out.println("========================================");
            System.out.print("Your choice: ");

            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    inputDataMenu();
                    break;
                case 2:
                    airportMenu();
                    break;
                case 3:
                    fixedwingMenu();
                    break;
                case 4:
                    helicopterMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    // ==================== 1. INPUT DATA ====================
    private static void inputDataMenu() {
        System.out.println("\n--- Input Data From Keyboard ---");
        System.out.println("1. Add Fixed Wing Airplane");
        System.out.println("2. Add Helicopter");
        System.out.println("3. Create new Airport");
        System.out.print("Your choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine().trim());
            switch (c) {
                case 1:
                    inputFixedWing();
                    break;
                case 2:
                    inputHelicopter();
                    break;
                case 3:
                    inputAirport();
                    break;
                default:
                    System.out.println("Error: Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void inputFixedWing() {
        try {
            System.out.println("\n-- Add Fixed Wing Airplane --");
            System.out.print("Model (max 40 chars): ");
            String model = scanner.nextLine();

            System.out.print("Plane type (CAG / LGR / PRV): ");
            String type = scanner.nextLine().trim().toUpperCase();

            System.out.print("Cruise speed: ");
            double cs = Double.parseDouble(scanner.nextLine());

            System.out.print("Empty weight: ");
            double ew = Double.parseDouble(scanner.nextLine());

            System.out.print("Max takeoff weight: ");
            double mtw = Double.parseDouble(scanner.nextLine());

            System.out.print("Min needed runway size: ");
            double runway = Double.parseDouble(scanner.nextLine());

            fixedwingService.addFixedwing(model, type, cs, ew, mtw, runway);

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void inputHelicopter() {
        try {
            System.out.println("\n-- Add Helicopter --");
            System.out.print("Model (max 40 chars): ");
            String model = scanner.nextLine();

            System.out.print("Cruise speed: ");
            double cs = Double.parseDouble(scanner.nextLine());

            System.out.print("Empty weight: ");
            double ew = Double.parseDouble(scanner.nextLine());

            System.out.print("Max takeoff weight: ");
            double mtw = Double.parseDouble(scanner.nextLine());

            System.out.print("Range: ");
            double range = Double.parseDouble(scanner.nextLine());

            helicopterService.addHelicopter(model, cs, ew, mtw, range);

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void inputAirport() {
        try {
            System.out.println("\n-- Create New Airport --");
            System.out.print("Airport name: ");
            String name = scanner.nextLine();

            System.out.print("Runway size: ");
            double runway = Double.parseDouble(scanner.nextLine());

            System.out.print("Max fixed wing parking places: ");
            int mfw = Integer.parseInt(scanner.nextLine());

            System.out.print("Max helicopter parking places: ");
            int mrw = Integer.parseInt(scanner.nextLine());

            Validation.validateRunwaySize(runway);
            Validation.validatePositiveInt(mfw, "max fixed wing parking");
            Validation.validatePositiveInt(mrw, "max helicopter parking");

            airportService.createAirport(name, runway, mfw, mrw);

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    // ==================== 2. AIRPORT MANAGEMENT ====================
    static void airportMenu() {
        System.out.println("\n--- Airport Management ---");
        System.out.println("1. Display list of all airports (sorted by ID)");
        System.out.println("2. Display status of one airport (by ID)");
        System.out.println("3. Add fixed wing airplane(s) to airport");      // requirement b
        System.out.println("4. Add helicopter(s) to airport");               // requirement d
        System.out.println("5. Remove helicopter(s) from airport");          // requirement c, e
        System.out.print("Your choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine().trim());
            switch (c) {
                case 1:
                    displayAllAirports();
                    break;
                case 2:
                    displayOneAirport();
                    break;
                case 3:
                    addFixedWingsToAirport();
                    break;
                case 4:
                    addHelicoptersToAirport();
                    break;
                case 5:
                    removeHelicoptersFromAirport();
                    break;
                default:
                    System.out.println("Error: Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void displayAllAirports() {
        List<Airport> list = airportService.getAllAirportsSortedById();
        if (list.isEmpty()) {
            System.out.println("No airports found.");
            return;
        }
        System.out.println("\n-- All Airports (sorted by ID) --");
        for (Airport a : list) {
            System.out.println(a);
            System.out.println("-----------------------------");
        }
    }

    static void displayOneAirport() {
        System.out.print("Enter Airport ID: ");
        String id = scanner.nextLine().trim();
        Airport ap = airportService.getAirportById(id);
        if (ap != null) {
            System.out.println("\n-- Airport Status --");
            System.out.println(ap);
        } else {
            System.out.println("Error: Airport with ID " + id + " not found.");
        }
    }

    // requirement b: add one or more fixed wing - chưa đậu ở đâu + min runway < airport runway
    static void addFixedWingsToAirport() {
        System.out.print("Enter Airport ID: ");
        String airportId = scanner.nextLine().trim();

        Airport airport = airportService.getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport not found.");
            return;
        }

        System.out.print("Enter Fixed Wing ID(s) (comma separated, e.g. FW00001,FW00002): ");
        String input = scanner.nextLine().trim();
        String[] ids = input.split(",");

        for (String fwId : ids) {
            fwId = fwId.trim();
            Fixedwing fw = fixedwingService.getById(fwId);
            if (fw == null) {
                System.out.println("Error: Fixed wing " + fwId + " not found.");
                continue;
            }
            airportService.addFixedWingToAirport(airportId, fwId, fw.getMinNeededRunwaySize());
        }
    }

    // requirement d: add one or more helicopters - chưa đậu ở đâu
    static void addHelicoptersToAirport() {
        System.out.print("Enter Airport ID: ");
        String airportId = scanner.nextLine().trim();

        Airport airport = airportService.getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport not found.");
            return;
        }

        System.out.print("Enter Helicopter ID(s) (comma separated, e.g. RW00001,RW00002): ");
        String input = scanner.nextLine().trim();
        String[] ids = input.split(",");

        for (String rwId : ids) {
            rwId = rwId.trim();
            Helicopter h = helicopterService.getById(rwId);
            if (h == null) {
                System.out.println("Error: Helicopter " + rwId + " not found.");
                continue;
            }
            airportService.addHelicopterToAirport(airportId, rwId);
        }
    }

    // requirement c, e: remove one or more helicopters
    static void removeHelicoptersFromAirport() {
        System.out.print("Enter Airport ID: ");
        String airportId = scanner.nextLine().trim();

        Airport airport = airportService.getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport not found.");
            return;
        }

        System.out.print("Enter Helicopter ID(s) to remove (comma separated, e.g. RW00001,RW00002): ");
        String input = scanner.nextLine().trim();
        String[] ids = input.split(",");

        for (String rwId : ids) {
            rwId = rwId.trim();
            airportService.removeHelicopterFromAirport(airportId, rwId);
        }
    }

    // ==================== 3. FIXED WING MANAGEMENT ====================
    static void fixedwingMenu() {
        System.out.println("\n--- Fixed Wing Airplane Management ---");
        System.out.println("1. Display list of all fixed wing airplanes");
        System.out.println("2. Change plane type and min needed runway size"); // requirement f
        System.out.print("Your choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine().trim());
            switch (c) {
                case 1:
                    displayAllFixedWings();
                    break;
                case 2:
                    changePlaneTypeAndRunway();
                    break;
                default:
                    System.out.println("Error: Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void displayAllFixedWings() {
        List<Fixedwing> list = fixedwingService.getAllFixedwings();
        if (list.isEmpty()) {
            System.out.println("No fixed wing airplanes found.");
            return;
        }
        System.out.println("\n-- All Fixed Wing Airplanes --");
        for (Fixedwing fw : list) {
            String parkingInfo = airportService.findAirportOfFixedWing(fw.getId());
            System.out.println(fw);
            System.out.println("  Parking Airport: " + parkingInfo);
            System.out.println("-----------------------------");
        }
    }

    static void changePlaneTypeAndRunway() {
        try {
            System.out.print("Enter Fixed Wing ID: ");
            String id = scanner.nextLine().trim();

            Fixedwing fw = fixedwingService.getById(id);
            if (fw == null) {
                System.out.println("Error: Fixed wing " + id + " not found.");
                return;
            }

            System.out.print("New plane type (CAG / LGR / PRV): ");
            String type = scanner.nextLine().trim().toUpperCase();

            System.out.print("New min needed runway size: ");
            double runway = Double.parseDouble(scanner.nextLine());

            fixedwingService.updatePlaneTypeAndRunway(id, type, runway);

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }
// ==================== 4. HELICOPTER MANAGEMENT ====================

    static void helicopterMenu() {
        System.out.println("\n--- Helicopter Management Group ---");
        System.out.println("1. Display list of all helicopters");
        System.out.print("Your choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine().trim());
            if (c == 1) {
                displayAllHelicopters();
            } else {
                System.out.println("Error: Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    static void displayAllHelicopters() {
        List<Helicopter> list = helicopterService.getAllHelicopters();
        if (list.isEmpty()) {
            System.out.println("No helicopters found.");
            return;
        }
        System.out.println("\n-- All Helicopters --");
        for (Helicopter h : list) {
            String parkingInfo = airportService.findAirportOfHelicopter(h.getId());
            System.out.println(h);
            System.out.println("  Parking Airport: " + parkingInfo);
            System.out.println("-----------------------------");
        }
    }
}
