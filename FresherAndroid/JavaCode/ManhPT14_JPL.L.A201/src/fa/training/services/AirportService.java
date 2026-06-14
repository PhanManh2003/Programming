package fa.training.services;

import fa.training.entities.Airport;
import fa.training.utils.Validation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportService {

    private List<Airport> airports = new ArrayList<>();
    private int airportCounter = 1;
    private static final String FILE_PATH = "airports.txt";

    // ==================== GENERATE ID ====================
    private String generateAirportId() {
        return String.format("AP%05d", airportCounter++);
    }

    // ==================== a. CREATE AIRPORT ====================
    public Airport createAirport(String name, double runwaySize,
            int maxFW, int maxRW) {
        String id = generateAirportId();
        List<String> fixedWingIds = new ArrayList<>();
        List<String> helicopterIds = new ArrayList<>();
        Airport airport = new Airport(id, name, runwaySize, maxFW, maxRW, 
                fixedWingIds, helicopterIds);
        airports.add(airport);
        saveToFile();
        System.out.println("Airport created successfully! ID: " + id);
        return airport;
    }

    // ==================== GET ALL SORTED BY ID ====================
    public List<Airport> getAllAirportsSortedById() {
        List<Airport> sorted = new ArrayList<>(airports);
        sorted.sort(Comparator.comparing(Airport::getId));
        return sorted;
    }

    // ==================== GET BY ID ====================
    public Airport getAirportById(String id) {
        for (Airport a : airports) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    // ==================== b. ADD A FIXED WING TO AIRPORT ====================
    // - Fixed wing chưa đậu ở sân bay nào
    // - Min needed runway size < airport runway size
    // - Còn chỗ đậu
    public boolean addFixedWingToAirport(String airportId, String fwId,
            double minNeededRunway) {
        Airport airport = getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport " + airportId + " not found.");
            return false;
        }

        // Check fixed wing đã đậu ở sân bay nào chưa
        for (Airport a : airports) {
            if (a.getFixedWingAirplaneIds().contains(fwId)) {
                System.out.println("Error: Fixed wing " + fwId
                        + " is already parked at airport " + a.getId() + " - " + a.getName());
                return false;
            }
        }

        // Check min runway size
        if (!Validation.canParkFixedWing(minNeededRunway, airport.getRunwaySize())) {
            System.out.println("Error: Fixed wing " + fwId
                    + " min needed runway size (" + minNeededRunway
                    + ") exceeds airport runway size (" + airport.getRunwaySize() + ").");
            return false;
        }

        // Check còn chỗ đậu
        if (airport.getFixedWingAirplaneIds().size() >= airport.getMaxFixedWingParkingPlace()) {
            System.out.println("Error: Airport " + airportId + " fixed wing parking is full. ("
                    + airport.getMaxFixedWingParkingPlace() + " places)");
            return false;
        }

        airport.getFixedWingAirplaneIds().add(fwId);
        saveToFile();
        System.out.println("Fixed wing " + fwId + " added to airport " + airportId + " successfully.");
        return true;
    }

    // ==================== d. ADD A HELICOPTER TO AIRPORT ====================
    // - Helicopter chưa đậu ở sân bay nào
    // - Còn chỗ đậu
    public boolean addHelicopterToAirport(String airportId, String rwId) {
        Airport airport = getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport " + airportId + " not found.");
            return false;
        }

        // Check helicopter đã đậu ở sân bay nào chưa
        for (Airport a : airports) {
            if (a.getHelicopterIds().contains(rwId)) {
                System.out.println("Error: Helicopter " + rwId
                        + " is already parked at airport " + a.getId() + " - " + a.getName());
                return false;
            }
        }

        // Check còn chỗ đậu
        if (airport.getHelicopterIds().size() >= airport.getMaxRotatedWingParkingPlace()) {
            System.out.println("Error: Airport " + airportId + " helicopter parking is full. ("
                    + airport.getMaxRotatedWingParkingPlace() + " places)");
            return false;
        }

        airport.getHelicopterIds().add(rwId);
        saveToFile();
        System.out.println("Helicopter " + rwId + " added to airport " + airportId + " successfully.");
        return true;
    }

    // ==================== c, e. REMOVE A HELICOPTER FROM AIRPORT ====================
    public boolean removeHelicopterFromAirport(String airportId, String rwId) {
        Airport airport = getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport " + airportId + " not found.");
            return false;
        }

        if (!airport.getHelicopterIds().contains(rwId)) {
            System.out.println("Error: Helicopter " + rwId
                    + " is not parked at airport " + airportId + ".");
            return false;
        }

        airport.getHelicopterIds().remove(rwId);
        saveToFile();
        System.out.println("Helicopter " + rwId + " removed from airport " + airportId + " successfully.");
        return true;
    }

    // ==================== REMOVE A FIXED WING FROM AIRPORT ====================
    public boolean removeFixedWingFromAirport(String airportId, String fwId) {
        Airport airport = getAirportById(airportId);
        if (airport == null) {
            System.out.println("Error: Airport " + airportId + " not found.");
            return false;
        }

        if (!airport.getFixedWingAirplaneIds().contains(fwId)) {
            System.out.println("Error: Fixed wing " + fwId
                    + " is not parked at airport " + airportId + ".");
            return false;
        }

        airport.getFixedWingAirplaneIds().remove(fwId);
        saveToFile();
        System.out.println("Fixed wing " + fwId + " removed from airport " + airportId + " successfully.");
        return true;
    }

    // ==================== FIND AIRPORT OF FIXED WING ====================
    public String findAirportOfFixedWing(String fwId) {
        for (Airport a : airports) {
            if (a.getFixedWingAirplaneIds().contains(fwId)) {
                return a.getId() + " - " + a.getName();
            }
        }
        return "Not parked";
    }

    // ==================== FIND AIRPORT OF HELICOPTER ====================
    public String findAirportOfHelicopter(String rwId) {
        for (Airport a : airports) {
            if (a.getHelicopterIds().contains(rwId)) {
                return a.getId() + " - " + a.getName();
            }
        }
        return "Not parked";
    }

    // ==================== SAVE AIRPORTSa TO FILE ====================
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Airport a : airports) {
                // Format: id|name|runwaySize|maxFW|maxRW|fw1,fw2,...|rw1,rw2,...
                String fwIds = String.join(",", a.getFixedWingAirplaneIds());
                String rwIds = String.join(",", a.getHelicopterIds());
                pw.println(a.getId() + "|" + a.getName() + "|"
                        + a.getRunwaySize() + "|"
                        + a.getMaxFixedWingParkingPlace() + "|"
                        + a.getMaxRotatedWingParkingPlace() + "|"
                        + fwIds + "|" + rwIds);
            }
        } catch (IOException e) {
            System.out.println("Error saving airports: " + e.getMessage());
        }
    }

    // ==================== LOAD AIRPORTS FROM FILE ====================
    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", -1);
                if (parts.length == 7) {
                    List<String> fwIds = new ArrayList<>();
                    List<String> rwIds = new ArrayList<>();

                    if (!parts[5].isEmpty()) {
                        fwIds.addAll(Arrays.asList(parts[5].split(",")));
                    }
                    if (!parts[6].isEmpty()) {
                        rwIds.addAll(Arrays.asList(parts[6].split(",")));
                    }

                    Airport airport = new Airport(
                            parts[0],
                            parts[1],
                            Double.parseDouble(parts[2]),
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]),
                            fwIds,
                            rwIds
                    );
                    airports.add(airport);
                    airportCounter++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading airports: " + e.getMessage());
        }
    }

    // ==================== GETTER ====================
    public List<Airport> getAirports() {
        return airports;
    }
}
