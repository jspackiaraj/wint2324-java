import java.util.List;

public class CalculateDeterminant {

    public static double calculate(Matrix matrix) {
        List<List<Double>> data = matrix.getData();
        if (data.size() == 1) {
            return data.get(0).get(0);
        }
        if (data.size() == 2) {
            return data.get(0).get(0) * data.get(1).get(1) - data.get(0).get(1) * data.get(1).get(0);
        }
        double determinant = 0.0;
        for (int i = 0; i < data.size(); i++) {
            Matrix subMatrix = SubMatrixCalculator.getSubMatrix(matrix, 0, i);
            determinant += Math.pow(-1, i) * data.get(0).get(i) * calculate(subMatrix);
        }
        return determinant;
    }
}
