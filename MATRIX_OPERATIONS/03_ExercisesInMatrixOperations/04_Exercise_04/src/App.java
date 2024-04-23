import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List<List<Double>> data = MatrixFileReader.readMatrixFromFile("linecoordinates.txt").getData();
            double alpha = Math.toRadians(data.get(0).get(6));  // Convert rotation angle around X-axis from degrees to radians
            double beta = Math.toRadians(data.get(0).get(7));   // Convert rotation angle around Y-axis from degrees to radians
            double theta = Math.toRadians(data.get(0).get(8));  // Convert rotation angle around Z-axis from degrees to radians

            // Define the rotation matrices for X, Y, and Z axis
            Matrix Rx = new Matrix(List.of(
                List.of(1.0, 0.0, 0.0),
                List.of(0.0, Math.cos(alpha), -Math.sin(alpha)),
                List.of(0.0, Math.sin(alpha), Math.cos(alpha))
            ));

            Matrix Ry = new Matrix(List.of(
                List.of(Math.cos(beta), 0.0, Math.sin(beta)),
                List.of(0.0, 1.0, 0.0),
                List.of(-Math.sin(beta), 0.0, Math.cos(beta))
            ));

            Matrix Rz = new Matrix(List.of(
                List.of(Math.cos(theta), -Math.sin(theta), 0.0),
                List.of(Math.sin(theta), Math.cos(theta), 0.0),
                List.of(0.0, 0.0, 1.0)
            ));

            // Initial coordinates of the line endpoints
            Matrix P1 = new Matrix(List.of(
                List.of(data.get(0).get(0)),
                List.of(data.get(0).get(1)),
                List.of(data.get(0).get(2))
            ));

            Matrix P2 = new Matrix(List.of(
                List.of(data.get(0).get(3)),
                List.of(data.get(0).get(4)),
                List.of(data.get(0).get(5))
            ));

            // Apply rotation to each point
            Matrix newP1 = MatrixMultiplication.multiply(MatrixMultiplication.multiply(Rz, Ry), Rx);
            newP1 = MatrixMultiplication.multiply(newP1, P1);
            Matrix newP2 = MatrixMultiplication.multiply(MatrixMultiplication.multiply(Rz, Ry), Rx);
            newP2 = MatrixMultiplication.multiply(newP2, P2);

            // Output the new coordinates
            System.out.println("Rotated Line Endpoints:");
            MatrixPrinter.printMatrix(newP1);
            MatrixPrinter.printMatrix(newP2);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
