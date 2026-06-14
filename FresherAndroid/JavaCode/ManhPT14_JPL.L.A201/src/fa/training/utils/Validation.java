package fa.training.utils;

public class Validation {

    public static void validateFixedWingId(String id) throws ValidationException {
        if (id == null || !id.matches("FW\\d{5}")) {
            throw new ValidationException("Invalid Fixed Wing ID: must start with 'FW' followed by 5 digits.");
        }
    }

    public static void validateHelicopterId(String id) throws ValidationException {
        if (id == null || !id.matches("RW\\d{5}")) {
            throw new ValidationException("Invalid Helicopter ID: must start with 'RW' followed by 5 digits.");
        }
    }

    public static void validateAirportId(String id) throws ValidationException {
        if (id == null || !id.matches("AP\\d{5}")) {
            throw new ValidationException("Invalid Airport ID: must start with 'AP' followed by 5 digits.");
        }
    }

    public static void validateModel(String model) throws ValidationException {
        if (model == null || model.trim().isEmpty()) {
            throw new ValidationException("Model cannot be empty.");
        }
        if (model.length() > 40) {
            throw new ValidationException("Model is too long: max 40 characters.");
        }
    }

    public static void validatePlaneType(String type) throws ValidationException {
        if (type == null || (!type.equals("CAG") && !type.equals("LGR") && !type.equals("PRV"))) {
            throw new ValidationException("Invalid plane type: must be CAG, LGR, or PRV.");
        }
    }

    public static void validateHelicopterWeight(double emptyWeight, double maxTakeoffWeight)
            throws ValidationException {
        if (maxTakeoffWeight > 1.5 * emptyWeight) {
            throw new ValidationException("Invalid weight: max takeoff weight (" + maxTakeoffWeight
                    + ") must not exceed 1.5 times empty weight (" + emptyWeight + ")."
                    + " Max allowed: " + (1.5 * emptyWeight));
        }
    }

    public static void validateRunwaySize(double runwaySize) throws ValidationException {
        if (runwaySize <= 0) {
            throw new ValidationException("Invalid runway size: must be greater than 0.");
        }
    }

    public static void validatePositiveNumber(double value, String fieldName)
            throws ValidationException {
        if (value <= 0) {
            throw new ValidationException("Invalid " + fieldName + ": must be greater than 0.");
        }
    }

    public static void validatePositiveInt(int value, String fieldName)
            throws ValidationException {
        if (value <= 0) {
            throw new ValidationException("Invalid " + fieldName + ": must be greater than 0.");
        }
    }

    // Giữ lại method cũ để dùng trong AirportService
    public static boolean canParkFixedWing(double minNeededRunway, double airportRunway) {
        return minNeededRunway <= airportRunway;
    }
}