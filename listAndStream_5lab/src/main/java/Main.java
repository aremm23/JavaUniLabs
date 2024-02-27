import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static List<Integer> list = new LinkedList<>();
    private static boolean menuRepeater = true;

    public static void main(String[] args) {
        while (menuRepeater) {
            menu();
        }
    }


    public static void menu() {
        System.out.println("""
                1. Add number to list;
                2. Delete number from list;
                3. Delete nearest number;
                4. Print list;
                other number to quit.
                """);
        menuProcedure();
    }

    public static void menuProcedure() {
        switch (in.nextInt()) {
            case 1 -> numberInput();
            case 2 -> deleteElement();
            case 3 -> deleteNearestNumber();
            case 4 -> printList();
            default -> menuRepeater = false;
        }
    }

    public static void addNumber(int number) {
        list.add(number);
    }

    public static void numberInput() {
        System.out.println("Start enter numbers. To cancel insert 0");
        int number;
        while ((number = enterNumber()) != 0) {
            addNumber(number);
        }
    }

    public static Integer enterNumber() throws InputMismatchException {
        System.out.println("Enter number: ");
        return in.nextInt();
    }

    public static void deleteElement() throws InputMismatchException {
        int number = enterNumber();
        list = list.stream().filter(element -> element != number).toList();
    }

    public static void printList() {
        System.out.print("Your list: [");
        list.stream().forEach(element -> System.out.print(element + " "));
        System.out.println("]\n");
    }

    public static void deleteNearestNumber() {
        int closestNum = enterNumber();
        final int diffConst = findClosestDifference(closestNum);
        list = list.stream().filter(element -> Math.abs(element - closestNum) > diffConst).toList();
    }

    public static int findClosestDifference(int closestNum) {
        int diff = Math.abs(closestNum - list.get(0));
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i) - closestNum) < diff) {
                diff = Math.abs(list.get(i) - closestNum);
            }
        }
        return diff;
    }
}