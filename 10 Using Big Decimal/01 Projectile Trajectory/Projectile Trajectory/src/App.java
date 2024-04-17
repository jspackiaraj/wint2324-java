import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the air resistance proportionality constant (k): ");
            BigDecimal k = scanner.nextBigDecimal();

            System.out.println("Enter the time step (delta time): ");
            BigDecimal deltaTime = scanner.nextBigDecimal();

            System.out.println("Enter the initial velocity in X direction (m/s): ");
            BigDecimal initialVelocityX = scanner.nextBigDecimal();

            System.out.println("Enter the initial velocity in Y direction (m/s): ");
            BigDecimal initialVelocityY = scanner.nextBigDecimal();

            System.out.println("Enter the rounding scale (number of decimal places): ");
            int scale = scanner.nextInt();

            ProjectileMotionCalculator calculator = new ProjectileMotionCalculator(k, deltaTime, scale);
            List<BigDecimal[]> positions = calculator.simulateMotion(initialVelocityX, initialVelocityY);

            // Print the projectile trajectory coordinates on the screen
            System.out.println("Projectile trajectory (x, y): ");
            for (BigDecimal[] position : positions) {
                System.out.printf("(%s, %s)\n", position[0].toPlainString(), position[1].toPlainString());
            }

            // Save the simulation steps to an HTML file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProjectileMotionSimulation.html"))) {
                writer.write(calculator.getCalculationSteps());
                System.out.println("Simulation steps written to ProjectileMotionSimulation.html");
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }

            // Save coordinates to a CSV file
            String csvFileName = "ProjectileTrajectory.csv";
            try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(csvFileName))) {
                csvWriter.write("x,y\n"); // CSV header
                for (BigDecimal[] position : positions) {
                    csvWriter.write(position[0].toPlainString() + "," + position[1].toPlainString() + "\n");
                }
                System.out.println("Coordinates saved to " + csvFileName);
            } catch (IOException e) {
                System.err.println("An error occurred while saving coordinates to the CSV file: " + e.getMessage());
            }
        }
    }
}
