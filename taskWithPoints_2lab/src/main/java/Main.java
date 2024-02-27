//1 A 4 3 1 B 8,3 3 1 C 9 3
import Point.DistanceBetweenPoints;
import Point.Point;
import Point.CollinearPoints;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Map<String, Point> mapWithPoints = new HashMap<>();
    public static boolean menuRepeated = true;

    public static void main(String[] args) {
        while (menuRepeated) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("""
                1. To create a point;
                2. To find distance between points;
                3. To find distance from (0; 0);
                4. To find out if points lie on one line or not;
                5. To look at all active points;
                other symbol to exit
                """);
        menuProcessing();
    }

    public static void menuProcessing() {
        switch (in.nextInt()) {
            case 1 -> {
                Point point = makePoint();
                mapWithPoints.put(point.getName(), point);
            }
            case 2 -> {
                findDistance();
            }
            case 3 -> {
                findDistanceFromOrigin();
            }
            case 4 -> {
                checkIfPointsCollinear();
            }
            case 5 -> {
                showPoints();
            }
            default -> {
                menuRepeated = false;
            }
        }
    }

    public static void checkIfPointsCollinear() {
        Point point1, point2, point3;
        try {
            System.out.println("Enter first point name:");
            point1 = mapWithPoints.get(in.next());
            System.out.println("Enter second point name:");
            point2 = mapWithPoints.get(in.next());
            System.out.println("Enter third point name:");
            point3 = mapWithPoints.get(in.next());
        } catch (NullPointerException e) {
            throw new NullPointerException("There no such points");
        }
        CollinearPoints collinearPoints = new CollinearPoints(point1, point2, point3);
        System.out.printf("Points %s (%.2f;%.2f), %s (%.2f;%.2f) and %s (%.2f;%.2f)", point1.getName(), point1.getX(),
                point1.getY(), point2.getName(), point2.getX(), point2.getY(), point3.getName(), point3.getX(), point3.getY());
        if (collinearPoints.getIsCollinear()) System.out.println(" lie on same line");
        else System.out.println("DONT lie on same line");
    }

    public static void showPoints() {
        if (mapWithPoints.isEmpty()) throw new NullPointerException("There no points");
        for (Map.Entry<String, Point> point : mapWithPoints.entrySet()) {
            System.out.println(point.getValue().getName() + " (" + point.getValue().getX() + ";" + point.getValue().getY() + ")");
        }
    }

    public static void findDistance() {
        Point point1, point2;
        try {
            System.out.println("Enter first point name:");
            point1 = mapWithPoints.get(in.next());
            System.out.println("Enter second point name:");
            point2 = mapWithPoints.get(in.next());
        } catch (NullPointerException e) {
            throw new NullPointerException("There no such point");
        }
        DistanceBetweenPoints distanceBetweenPoints = new DistanceBetweenPoints(point1, point2);
        System.out.printf("Distance between points %s (%.2f;%.2f) and %s (%.2f;%.2f) is %.2f \n", point1.getName(), point1.getX(),
                point1.getY(), point2.getName(), point2.getX(), point2.getY(), distanceBetweenPoints.getDistance());
    }

    public static void findDistanceFromOrigin() {
        Point point = null;
        System.out.println("Enter point name:");
        try {
            point = mapWithPoints.get(in.next());
        } catch (NullPointerException e) {
            throw new NullPointerException("There no such point");
        }
        DistanceBetweenPoints distanceBetweenPoints = new DistanceBetweenPoints(point);
        System.out.printf("Distance between points O(0;0) and %s (%.2f;%.2f) is %.2f\n",
                point.getName(), point.getX(), point.getY(), distanceBetweenPoints.getDistance());
    }

    public static Point makePoint() {
        System.out.println("Enter point name:");
        String name = in.next();
        System.out.println("Enter x: ");
        double x = in.nextDouble();
        System.out.println("Enter y: ");
        double y = in.nextDouble();
        return new Point(x, y, name);
    }
}