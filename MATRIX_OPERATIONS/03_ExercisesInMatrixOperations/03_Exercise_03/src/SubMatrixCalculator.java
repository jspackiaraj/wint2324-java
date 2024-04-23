import java.util.ArrayList;
import java.util.List;

public class SubMatrixCalculator {

    public static Matrix getSubMatrix(Matrix originalMatrix, int excludingRow, int excludingCol) {
        List<List<Double>> data = originalMatrix.getData();
        List<List<Double>> subMatrixData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (i == excludingRow) continue;
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                if (j == excludingCol) continue;
                row.add(data.get(i).get(j));
            }
            subMatrixData.add(row);
        }

        return new Matrix(subMatrixData);
    }
}
