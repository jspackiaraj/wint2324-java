import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        try {
            // Read the matrix from the file
            Matrix fullMatrix = MatrixFileReader.readMatrixFromFile("equations.csv");
            
            // Check if the matrix is properly augmented
            if (fullMatrix.getColumnCount() != fullMatrix.getRowCount() + 1) {
                throw new IllegalArgumentException("The provided matrix is not properly augmented for a system of equations. Expected columns: " + (fullMatrix.getRowCount() + 1) + ", but found: " + fullMatrix.getColumnCount());
            }

            // Use the SimEqnMatrixInversionMethod to solve the equations
            Matrix solution = SimEqnMatrixInversionMethod.solve(fullMatrix);

            // Print the solution vector
            System.out.println("Solution Vector:");
            MatrixPrinter.printMatrix(solution);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'equations.csv' could not be found.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
