import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to solve simultaneous equations using matrix inversion.
 */
public class SimEqnMatrixInversionMethod {

    /**
     * Splits the input matrix into the coefficient matrix and the constants vector,
     * then solves the equations by calculating the inverse of the coefficient matrix
     * and multiplying it by the constants vector.
     * 
     * @param fullMatrix The input matrix including both coefficients and constants.
     * @return The solution matrix.
     */
    public static Matrix solve(Matrix fullMatrix) {
        // Split the matrix into A (coefficients) and B (constants)
        List<List<Double>> data = fullMatrix.getData();
        List<List<Double>> coefficientsData = new ArrayList<>();
        List<List<Double>> constantsData = new ArrayList<>();

        for (List<Double> row : data) {
            List<Double> coefficientsRow = new ArrayList<>(row.subList(0, row.size() - 1));
            List<Double> constantsRow = new ArrayList<>();
            constantsRow.add(row.get(row.size() - 1));

            coefficientsData.add(coefficientsRow);
            constantsData.add(constantsRow);
        }

        Matrix A = new Matrix(coefficientsData);
        Matrix B = new Matrix(constantsData);

        // Calculate the inverse of A
        Matrix AInverse = CalculateInverse.calculate(A);

        // Multiply the inverse of A by B to get the solution
        Matrix X = MatrixMultiplication.multiply(AInverse, B);

        return X;
    }
}
