import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename of the matrix data file:");
        String fileName = scanner.nextLine().trim();

        try {
            Matrix matrix = MatrixFileReader.readMatrixFromFile(fileName);
            System.out.println("Matrix is square: " + matrix.isSquare());
            System.out.println("Number of rows: " + matrix.getRowCount());
            System.out.println("Number of columns: " + matrix.getColumnCount());

            if (matrix.isSquare()) {
                double determinant = CalculateDeterminant.calculate(matrix);
                System.out.printf("Determinant of the matrix is: %.3f\n", determinant);

                if (determinant != 0) {
                    Matrix inverseMatrix = CalculateInverse.calculate(matrix);
                    System.out.println("Inverse of the matrix is:");
                    MatrixPrinter.printMatrix(inverseMatrix); // Updated to use a Matrix object
                } else {
                    System.out.println("Matrix does not have an inverse (determinant is 0).");
                }
            } else {
                System.out.println("Determinant and inverse calculations require a square matrix.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
