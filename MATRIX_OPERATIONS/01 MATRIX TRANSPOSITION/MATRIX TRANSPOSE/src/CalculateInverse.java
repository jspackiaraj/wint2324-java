import java.util.ArrayList;
import java.util.List;

public class CalculateInverse {

    public static List<List<Double>> calculate(Matrix matrix) {
        double determinant = CalculateDeterminant.calculate(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is not invertible (determinant is 0).");
        }

        List<List<Double>> adjugateMatrix = calculateAdjugate(matrix.getData());
        return multiplyByScalar(adjugateMatrix, 1.0 / determinant);
    }

    private static List<List<Double>> calculateAdjugate(List<List<Double>> data) {
        List<List<Double>> cofactorMatrix = calculateCofactorMatrix(data);
        return transpose(cofactorMatrix);
    }

    private static List<List<Double>> calculateCofactorMatrix(List<List<Double>> data) {
        List<List<Double>> cofactorMatrix = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                double cofactor = Math.pow(-1, i + j) * CalculateDeterminant.calculate(new Matrix(getSubMatrix(data, i, j)));
                row.add(cofactor);
            }
            cofactorMatrix.add(row);
        }
        return cofactorMatrix;
    }

    private static List<List<Double>> transpose(List<List<Double>> matrix) {
        List<List<Double>> transposedMatrix = new ArrayList<>();
        final int N = matrix.get(0).size();
        for (int i = 0; i < N; i++) {
            List<Double> row = new ArrayList<>();
            for (List<Double> rowData : matrix) {
                row.add(rowData.get(i));
            }
            transposedMatrix.add(row);
        }
        return transposedMatrix;
    }

    private static List<List<Double>> getSubMatrix(List<List<Double>> data, int excludingRow, int excludingCol) {
        List<List<Double>> subMatrix = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i == excludingRow) continue;
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                if (j == excludingCol) continue;
                row.add(data.get(i).get(j));
            }
            subMatrix.add(row);
        }
        return subMatrix;
    }

    private static List<List<Double>> multiplyByScalar(List<List<Double>> matrix, double scalar) {
        List<List<Double>> result = new ArrayList<>();
        for (List<Double> row : matrix) {
            List<Double> newRow = new ArrayList<>();
            for (Double value : row) {
                newRow.add(value * scalar);
            }
            result.add(newRow);
        }
        return result;
    }
}
