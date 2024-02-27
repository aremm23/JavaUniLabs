import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static int[][] createArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size");
        int arraySize = in.nextInt();
        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++) {
                System.out.printf("Please, enter [ %d ; %d ] element: ", i+1, j+1);
                array[i][j] = in.nextInt();
            }
        }
        return array;
    }

    private static void showArray(int[][] array) {
        if (Arrays.deepEquals(array, new int[][] {{}})) {
            System.out.println("Your matrix is empty");
            return;
        }
        System.out.println("Your matrix:");
        for (int []arrayLine:array) {
            System.out.print("|\t");
            for (int arrayElement:arrayLine) {
                System.out.print(arrayElement + "\t");
            }
            System.out.print("|\n");
        }
    }

    private static int[][] rotateMatrix(int[][] array, int degrees) {
        if (array.length == 0) {
            System.out.println("Your matrix is empty");
            return new int[][]{{}};
        }
        int arraySize = array.length;
        int[][] arrayAfterRotation = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                switch (degrees) {
                    case 90 -> arrayAfterRotation[arraySize - 1 - j][i] = array[i][j];
                    case 180 -> arrayAfterRotation[i][arraySize - 1 - j] = array[i][j];
                    case 270 -> arrayAfterRotation[arraySize - 1 - i][arraySize - 1 - j] = array[i][j];
                }
            }
        }
        System.out.println("Your matrix before rotation:");
        showArray(array);
        System.out.println("Your matrix after rotation:");
        showArray(arrayAfterRotation);
        return arrayAfterRotation;
    }

    public static void menu() {
        int [][]array = {{}};
        boolean menuRepeated = true;
        while(menuRepeated) {
            System.out.println("""
                    Menu:
                    1. Create new matrix;
                    2. Show matrix;
                    3. Rotate matrix;
                    4. Delete matrix;
                    5. Exit.
                    """);
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1 -> {
                    array = createArray();
                }
                case 2 -> {
                    showArray(array);
                }
                case 3 -> {
                    System.out.println("""
                        Choose rotation degrees:
                        1. 90 deg;
                        2. 180 deg;
                        3. 270 deg.
                    """);
                    switch (in.nextInt ()) {
                        case 1 -> array = rotateMatrix(array, 90);
                        case 2 -> array = rotateMatrix(array, 180);
                        case 3 -> array = rotateMatrix(array, 270);
                        default -> System.out.println("No such point");
                    }
                }
                case 4 -> {
                    if (Arrays.deepEquals(array, new int[][] {{}})) {
                        System.out.println("Your matrix is empty");
                    }
                    array = new int[][]{{}};
                }
                case 5 -> menuRepeated = false;
                default -> System.out.println("No such menu point");
            }
        }
    }
}
