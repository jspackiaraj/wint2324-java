import java.util.List;

public class Matrix {
    protected List<List<Double>> data;

    public Matrix(List<List<Double>> data) {
        this.data = data;
    }

    public List<List<Double>> getData() {
        return data;
    }

    public boolean isSquare() {
        int rows = getRowCount();
        return rows > 0 && rows == getColumnCount();
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return data.isEmpty() ? 0 : data.get(0).size();
    }
}
