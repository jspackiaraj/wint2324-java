public class CalculateInverse {

    public static Matrix calculate(Matrix matrix) {
        double determinant = CalculateDeterminant.calculate(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is not invertible (determinant is 0).");
        }

        Matrix adjugateMatrix = CalculateAdjugateMatrix.calculate(matrix);
        return MultiplyMatrixByScalar.multiply(adjugateMatrix, 1.0 / determinant);
    }
}
