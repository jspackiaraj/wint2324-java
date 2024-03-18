import java.util.Scanner;

/**
 * Main application class for solving simultaneous equations using matrix inversion.
 */
public class App {

    /**
     * The entry point of the program.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the filename of the matrix data file:");
        String fileName = scanner.nextLine().trim();

        try {
            Matrix fullMatrix = MatrixFileReader.readMatrixFromFile(fileName);

            if (!isValidMatrix(fullMatrix)) {
                System.out.println("The provided matrix does not have n rows and n+1 columns.");
                return;
            }

            Matrix solution = SimEqnMatrixInversionMethod.solve(fullMatrix);

            System.out.println("Solution:");
            MatrixPrinter.printMatrix(solution);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Validates that the matrix has n rows and n+1 columns.
     * 
     * @param matrix The matrix to validate.
     * @return true if the matrix is valid, false otherwise.
     */
    private static boolean isValidMatrix(Matrix matrix) {
        int rowCount = matrix.getRowCount();
        int columnCount = matrix.getColumnCount();

        return rowCount + 1 == columnCount;
    }
}
