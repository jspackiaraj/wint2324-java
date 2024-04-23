public class CalculateAdjugateMatrix {

    public static Matrix calculate(Matrix matrix) {
        Matrix cofactorMatrix = CalculateCofactorMatrix.calculate(matrix);
        return TransposeMatrix.transpose(cofactorMatrix);
    }
}
