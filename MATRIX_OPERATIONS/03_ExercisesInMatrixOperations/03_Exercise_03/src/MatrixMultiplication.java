import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality to multiply two matrices together.
 */
public class MatrixMultiplication {

    /**
     * Multiplies two matrices together.
     * 
     * @param a The first matrix.
     * @param b The second matrix.
     * @return The result of multiplying matrix a by matrix b.
     * @throws IllegalArgumentException If the matrices cannot be multiplied due to incompatible dimensions.
     */
    public static Matrix multiply(Matrix a, Matrix b) {
        int aColumns = a.getColumnCount();
        int bRows = b.getRowCount();
        
        // Check if multiplication is possible
        if (aColumns != bRows) {
            throw new IllegalArgumentException("Matrices have incompatible dimensions and cannot be multiplied.");
        }
        
        List<List<Double>> resultData = new ArrayList<>();
        List<List<Double>> dataA = a.getData();
        List<List<Double>> dataB = b.getData();

        for (int i = 0; i < a.getRowCount(); i++) {
            List<Double> rowResult = new ArrayList<>();
            for (int j = 0; j < b.getColumnCount(); j++) {
                double cellSum = 0;
                for (int k = 0; k < aColumns; k++) { // or bRows, they are equal
                    cellSum += dataA.get(i).get(k) * dataB.get(k).get(j);
                }
                rowResult.add(cellSum);
            }
            resultData.add(rowResult);
        }

        return new Matrix(resultData);
    }
}
