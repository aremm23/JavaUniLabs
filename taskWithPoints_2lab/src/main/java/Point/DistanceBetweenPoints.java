package Point;

public class DistanceBetweenPoints {
    private final Point pointA;
    private final Point pointB;
    private final Double distance;

    public DistanceBetweenPoints(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.distance = findDistance();
    }
    //find distance between point and (0;0)
    public DistanceBetweenPoints(Point point) {
        this.pointA = point;
        this.pointB = new Point(0, 0, "O");
        this.distance = findDistance();
    }
    private Double findDistance() {
        return Math.sqrt(Math.pow(Math.abs(pointA.getX() - pointB.getX()), 2) +
                Math.pow(Math.abs(pointA.getY() - pointB.getY()), 2));
    }
    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Double getDistance() {
        return distance;
    }
}