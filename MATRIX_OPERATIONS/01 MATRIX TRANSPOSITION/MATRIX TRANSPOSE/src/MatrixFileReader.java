import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixFileReader {
    public static Matrix readMatrixFromFile(String filePath) throws FileNotFoundException {
        List<List<Double>> matrixData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                List<Double> row = new ArrayList<>();
                String[] parts = scanner.nextLine().split(",");
                for (String part : parts) {
                    row.add(Double.parseDouble(part.trim()));
                }
                matrixData.add(row);
            }
        }
        return new Matrix(matrixData);
    }
}
