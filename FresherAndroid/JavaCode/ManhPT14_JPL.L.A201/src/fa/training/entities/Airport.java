package fa.training.entities;

import java.util.List;

public class Airport {

    private String id;
    private String name;
    private double runwaySize;
    private int maxFixedWingParkingPlace;
    private List<String> fixedWingAirplaneIds;
    private int maxRotatedWingParkingPlace;
    private List<String> helicopterIds;

    public Airport() {
    }

    public Airport(String id, String name, double runwaySize,
            int maxFixedWingParkingPlace, int maxRotatedWingParkingPlace,
            List<String> fixedWingAirplaneIds,
             List<String> helicopterIds) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.fixedWingAirplaneIds = fixedWingAirplaneIds;
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.helicopterIds = helicopterIds;
    }

    // gt st
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(double runwaySize) {
        this.runwaySize = runwaySize;
    }

    public int getMaxFixedWingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public void setMaxFixedWingParkingPlace(int maxFixedWingParkingPlace) {
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
    }

    public List<String> getFixedWingAirplaneIds() {
        return fixedWingAirplaneIds;
    }

    public void setFixedWingAirplaneIds(List<String> fixedWingAirplaneIds) {
        this.fixedWingAirplaneIds = fixedWingAirplaneIds;
    }

    public int getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
    }

    public List<String> getHelicopterIds() {
        return helicopterIds;
    }

    public void setHelicopterIds(List<String> helicopterIds) {
        this.helicopterIds = helicopterIds;
    }

    @Override
    public String toString() {
        return "Airport ID: " + id
                + ", Name: " + name
                + ", RunwaySize: " + runwaySize
                + ", MaxFW Parking: " + maxFixedWingParkingPlace
                + " (Used: " + fixedWingAirplaneIds.size() + ")"
                + ", MaxRW Parking: " + maxRotatedWingParkingPlace
                + " (Used: " + helicopterIds.size() + ")"
                + "\n  Fixed Wing IDs: " + fixedWingAirplaneIds
                + "\n  Helicopter IDs: " + helicopterIds;
    }

}
