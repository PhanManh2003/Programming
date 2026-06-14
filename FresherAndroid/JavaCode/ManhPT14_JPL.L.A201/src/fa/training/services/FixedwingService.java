package fa.training.services;

import fa.training.entities.Fixedwing;
import fa.training.utils.Validation;
import fa.training.utils.ValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
  Service class dùng để quản lý danh sách Fixedwing:
  - Add máy bay
  - Tìm theo ID
  - Update thông tin
  - Lưu file / đọc file
 */
public class FixedwingService {

    private List<Fixedwing> fixedwings = new ArrayList<>();
    private int counter = 1;
    private static final String FILE_PATH = "fixedwings.txt";

    private String generateId() {
        return String.format("FW%05d", counter++);
    }

    public Fixedwing addFixedwing(String model, String planeType,
            double cruiseSpeed, double emptyWeight,
            double maxTakeoffWeight, double minNeededRunwaySize)
            throws ValidationException {

        // Validate
        Validation.validateModel(model);
        Validation.validatePlaneType(planeType);
        Validation.validatePositiveNumber(cruiseSpeed, "cruise speed");
        Validation.validatePositiveNumber(emptyWeight, "empty weight");
        Validation.validatePositiveNumber(maxTakeoffWeight, "max takeoff weight");
        Validation.validatePositiveNumber(minNeededRunwaySize, "min needed runway size");

        String id = generateId();
        Fixedwing fw = new Fixedwing(id, model, planeType, cruiseSpeed,
                emptyWeight, maxTakeoffWeight, minNeededRunwaySize);
        fixedwings.add(fw);
        saveToFile();
        System.out.println("Fixed wing added successfully! ID: " + id);
        return fw;
    }

    public Fixedwing getById(String id) {
        for (Fixedwing fw : fixedwings) {
            if (fw.getId().equals(id)) {
                return fw;
            }
        }
        return null;
    }

    public List<Fixedwing> getAllFixedwings() {
        return fixedwings;
    }

    public boolean updatePlaneTypeAndRunway(String id, String newType, double newRunway)
            throws ValidationException {
        Fixedwing fw = getById(id);
        if (fw == null) {
            throw new ValidationException("Fixed wing " + id + " not found.");
        }
        Validation.validatePlaneType(newType);
        Validation.validatePositiveNumber(newRunway, "min needed runway size");

        fw.setPlaneType(newType);
        fw.setMinNeededRunwaySize(newRunway);
        saveToFile();
        System.out.println("Fixed wing " + id + " updated successfully.");
        return true;
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Fixedwing fw : fixedwings) {
                pw.println(fw.getId() + "," + fw.getModel() + "," + fw.getPlaneType() + ","
                        + fw.getCruiseSpeed() + "," + fw.getEmptyWeight() + ","
                        + fw.getMaxTakeoffWeight() + "," + fw.getMinNeededRunwaySize());
            }
        } catch (IOException e) {
            System.out.println("Error saving fixedwings: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Fixedwing fw = new Fixedwing(parts[0], parts[1], parts[2],
                            Double.parseDouble(parts[3]), Double.parseDouble(parts[4]),
                            Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
                    fixedwings.add(fw);
                    counter++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading fixedwings: " + e.getMessage());
        }
    }
}
