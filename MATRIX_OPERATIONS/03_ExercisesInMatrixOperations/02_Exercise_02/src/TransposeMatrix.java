import java.util.ArrayList;
import java.util.List;

public class TransposeMatrix {

    public static Matrix transpose(Matrix matrix) {
        List<List<Double>> data = matrix.getData();
        List<List<Double>> transposedMatrix = new ArrayList<>();
        
        final int N = data.get(0).size();
        for (int i = 0; i < N; i++) {
            List<Double> row = new ArrayList<>();
            for (List<Double> rowData : data) {
                row.add(rowData.get(i));
            }
            transposedMatrix.add(row);
        }
        
        return new Matrix(transposedMatrix);
    }
}
