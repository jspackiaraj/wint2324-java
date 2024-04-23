import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        String filePath = "vectors.txt";                                            // The name of the file to be read, can also be got from user
        try {
            // Part A: Read the matrix from the file
            Matrix matrix = MatrixFileReader.readMatrixFromFile(filePath);         // Read matrix from CSV file
            
            // Part B: Calculate the cofactor matrix
            Matrix cofactorMatrix = CalculateCofactorMatrix.calculate(matrix);
            
            // Part C: Print the cofactor matrix
            System.out.println("Cofactor Matrix:");
            MatrixPrinter.printMatrix(cofactorMatrix);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + filePath + "' could not be found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
