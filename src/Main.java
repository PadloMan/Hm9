import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 4;
        int[][] matrix = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }
        System.out.println("Матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int evenRowSum = 0, oddRowSum = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    evenRowSum += matrix[i][j];
                }
            } else {
                for (int j = 0; j < size; j++) {
                    oddRowSum += matrix[i][j];
                }
            }
        }
        System.out.println("Сума елементів парних рядків: " + evenRowSum);
        System.out.println("Сума елементів непарних рядків: " + oddRowSum);
        int evenColumnProduct = 1, oddColumnProduct = 1;
        for (int j = 0; j < size; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    evenColumnProduct *= matrix[i][j];
                }
            } else {
                for (int i = 0; i < size; i++) {
                    oddColumnProduct *= matrix[i][j];
                }
            }
        }
        System.out.println("Добуток елементів парних стовпців: " + evenColumnProduct);
        System.out.println("Добуток елементів непарних стовпців: " + oddColumnProduct);

        boolean isMagicSquare = isMagicSquare(matrix);
        System.out.println("Матриця є магічним квадратом: " + isMagicSquare);
    }
    private static boolean isMagicSquare(int[][] matrix) {
        int size = matrix.length;
        int magicSum = 0;
        for (int j = 0; j < size; j++) {
            magicSum += matrix[0][j];
        }

        // Перевірка рядків
        for (int i = 1; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }
        // Перевірка стовпців
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }
        // Перевірка головної діагоналі
        int diag1Sum = 0;
        for (int i = 0; i < size; i++) {
            diag1Sum += matrix[i][i];
        }
        if (diag1Sum != magicSum) {
            return false;
        }
        // Перевірка другорядної діагоналі
        int diag2Sum = 0;
        for (int i = 0; i < size; i++) {
            diag2Sum += matrix[i][size - 1 - i];
        }
        if (diag2Sum != magicSum) {
            return false;
        }
        return true;
    }
}