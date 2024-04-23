import java.util.Scanner;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        String filePath = "matrix.txt";                                            // The name of the file to be read, can also be got from user
        try {
            Matrix matrix = MatrixFileReader.readMatrixFromFile(filePath);         // Read matrix from CSV file
            MatrixPrinter.printMatrix(matrix);                                     // Print the original matrix
            
            Scanner scanner = new Scanner(System.in);                              // Scanner for user input
            System.out.print("Enter a scalar value: ");                            // Prompt for scalar input
            double scalar = scanner.nextDouble();                                  // Read scalar value from console
            
            Matrix scaledMatrix = MultiplyMatrixByScalar.multiply(matrix, scalar); // Scale matrix
            MatrixPrinter.printMatrix(scaledMatrix);                               // Print scaled matrix
            scanner.close();                                                       // Close scanner to prevent leaks
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + filePath + " could not be found.");
        }
    }
}
