import java.util.ArrayList;
import java.util.List;

public class Matrix {
    protected List<List<Double>> data;

    // Existing constructor
    public Matrix(List<List<Double>> data) {
        this.data = data;
    }

    // Overloaded constructor to create an empty matrix of given dimensions
    public Matrix(int rows, int columns) {
        data = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            List<Double> row = new ArrayList<>(columns);
            for (int j = 0; j < columns; j++) {
                row.add(0.0);  // Initialize with zeros
            }
            data.add(row);
        }
    }

    // Method to get data
    public List<List<Double>> getData() {
        return data;
    }

    // Method to check if the matrix is square
    public boolean isSquare() {
        int rows = getRowCount();
        return rows > 0 && rows == getColumnCount();
    }

    // Method to get the number of rows
    public int getRowCount() {
        return data.size();
    }

    // Method to get the number of columns
    public int getColumnCount() {
        return data.isEmpty() ? 0 : data.get(0).size();
    }

    // Method to get an element from the matrix
    public double getElement(int i, int j) {
        if (i < 0 || i >= getRowCount() || j < 0 || j >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Index out of bounds for matrix dimensions.");
        }
        return data.get(i).get(j);
    }

    // Method to set an element in the matrix
    public void setElement(int i, int j, double value) {
        if (i < 0 || i >= getRowCount() || j < 0 || j >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Index out of bounds for matrix dimensions.");
        }
        data.get(i).set(j, value);
    }
}
