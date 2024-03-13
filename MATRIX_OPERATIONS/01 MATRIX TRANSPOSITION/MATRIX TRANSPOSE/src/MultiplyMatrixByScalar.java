import java.util.ArrayList;
import java.util.List;

public class MultiplyMatrixByScalar {

    public static Matrix multiply(Matrix matrix, double scalar) {
        List<List<Double>> data = matrix.getData();
        List<List<Double>> result = new ArrayList<>();
        
        for (List<Double> row : data) {
            List<Double> newRow = new ArrayList<>();
            for (Double value : row) {
                newRow.add(value * scalar);
            }
            result.add(newRow);
        }
        
        return new Matrix(result);
    }
}
