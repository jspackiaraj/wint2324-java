import java.util.List;

public class MatrixPrinter {

    public static void printMatrix(List<List<Double>> matrix) {
        for (List<Double> row : matrix) {
            for (Double value : row) {
                System.out.printf("%9.3f", value);
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}
