import java.util.ArrayList;
import java.util.List;

public class CalculateCofactorMatrix {
    
    public static Matrix calculate(Matrix matrix) {
        List<List<Double>> data = matrix.getData();
        List<List<Double>> cofactorMatrix = new ArrayList<>();
        
        for (int i = 0; i < data.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                Matrix subMatrix = SubMatrixCalculator.getSubMatrix(matrix, i, j);
                double cofactor = Math.pow(-1, i + j) * CalculateDeterminant.calculate(subMatrix);
                row.add(cofactor);
            }
            cofactorMatrix.add(row);
        }
        
        return new Matrix(cofactorMatrix);
    }
}
