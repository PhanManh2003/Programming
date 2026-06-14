package fa.training.entities;

public class Fixedwing extends Airplane {

    private String planeType; // CAG, LGR, PRV
    private double minNeededRunwaySize;

    public Fixedwing() {
    }

    public Fixedwing(String id, String model, String planeType,
            double cruiseSpeed, double emptyWeight,
            double maxTakeoffWeight, double minNeededRunwaySize) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.planeType = planeType;
        this.minNeededRunwaySize = minNeededRunwaySize;
    }
    //gt, st

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public double getMinNeededRunwaySize() {
        return minNeededRunwaySize;
    }

    public void setMinNeededRunwaySize(double minNeededRunwaySize) {
        this.minNeededRunwaySize = minNeededRunwaySize;
    }

    @Override
    public String fly() {
        return "fixed wing";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", PlaneType: " + planeType
                + ", MinNeededRunwaySize: " + minNeededRunwaySize
                + ", FlyMethod: " + fly();
    }

}
