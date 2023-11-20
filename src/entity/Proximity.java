package entity;

public class Proximity {
    private final Coordinate referencePoint;
    private final double distance;

    Proximity(Coordinate referencePoint, double distance) {
        this.referencePoint = referencePoint;
        this.distance = distance;
    }

    public Coordinate getReferencePoint() {
        return referencePoint;
    }

    public double getDistance() {
        return distance;
    }
}
