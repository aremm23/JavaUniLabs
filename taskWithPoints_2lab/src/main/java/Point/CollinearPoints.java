package Point;

public class CollinearPoints {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private boolean isCollinear;

    public CollinearPoints(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        setIsCollinear();
    }
    private void setIsCollinear() {
        this.isCollinear = isEqual();
    }

    private boolean isEqual() {
        double x1 = pointA.getX();
        double x2 = pointB.getX();
        double x3 = pointC.getX();
        double y3 = pointC.getY();
        double y2 = pointB.getY();
        double y1 = pointA.getY();

        double a = (y2 - y1);
        double b = (x2 - x1);
        double c = (a * x1 - b * y1);
        double result = (a * x3 - c) / b;
        double epsilon = 1e-10;
        return Math.abs(result - y3) < epsilon;
    }
    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public boolean getIsCollinear() {
        return isCollinear;
    }
}
