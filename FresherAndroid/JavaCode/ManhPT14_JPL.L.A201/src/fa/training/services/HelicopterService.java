package fa.training.services;

import fa.training.entities.Helicopter;
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

public class HelicopterService {

    private List<Helicopter> helicopters = new ArrayList<>();
    private int counter = 1;
    private static final String FILE_PATH = "helicopters.txt";

    private String generateId() {
        return String.format("RW%05d", counter++);
    }

    public Helicopter addHelicopter(String model, double cruiseSpeed,
            double emptyWeight, double maxTakeoffWeight,
            double range) throws ValidationException {
        // Validate
        Validation.validateModel(model);
        Validation.validatePositiveNumber(cruiseSpeed, "cruise speed");
        Validation.validatePositiveNumber(emptyWeight, "empty weight");
        Validation.validatePositiveNumber(maxTakeoffWeight, "max takeoff weight");
        Validation.validatePositiveNumber(range, "range");
        Validation.validateHelicopterWeight(emptyWeight, maxTakeoffWeight);

        String id = generateId();
        Helicopter h = new Helicopter(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
        helicopters.add(h);
        saveToFile();
        System.out.println("Helicopter added successfully! ID: " + id);
        return h;
    }

    public Helicopter getById(String id) {
        for (Helicopter h : helicopters) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }

    public List<Helicopter> getAllHelicopters() {
        return helicopters;
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Helicopter h : helicopters) {
                pw.println(h.getId() + "," + h.getModel() + "," + h.getCruiseSpeed()
                        + "," + h.getEmptyWeight() + "," + h.getMaxTakeoffWeight()
                        + "," + h.getRange());
            }
        } catch (IOException e) {
            System.out.println("Error saving helicopters: " + e.getMessage());
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
                if (parts.length == 6) {
                    Helicopter h = new Helicopter(parts[0], parts[1],
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                            Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
                    helicopters.add(h);
                    counter++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading helicopters: " + e.getMessage());
        }
    }
}
