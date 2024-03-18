import java.util.List;

public class MatrixPrinter {
    public static void printMatrix(Matrix matrix) {
        List<List<Double>> data = matrix.getData();
        for (List<Double> row : data) {
            for (Double value : row) {
                System.out.printf("%9.3f", value);
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}
