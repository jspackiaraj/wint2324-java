import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ProjectileMotionCalculator {
    private BigDecimal k;
    private BigDecimal g = new BigDecimal("9.8");
    private BigDecimal deltaTime;
    private int scale;
    private StringBuilder calculationSteps;
    private Instant startTime;
    private Instant endTime;
    private BigDecimal initialVelocityX;
    private BigDecimal initialVelocityY;
    private int totalSteps = 0;

    public ProjectileMotionCalculator(BigDecimal k, BigDecimal deltaTime, int scale) {
        this.k = k;
        this.deltaTime = deltaTime;
        this.scale = scale;
        this.calculationSteps = new StringBuilder();
        startHtml();
    }

    private void startHtml() {
        this.calculationSteps.append("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Projectile Motion Iterations</title>
                <style>
                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }
                    table, th, td {
                        border: 1px solid black;
                    }
                    th, td {
                        padding: 8px;
                        text-align: left;
                    }
                </style>
            </head>
            <body>
                <h2>Projectile Motion Iterations</h2>
                <table>
                    <tr>
                        <th>Iteration</th>
                        <th>x (m)</th>
                        <th>y (m)</th>
                        <th>vx (m/s)</th>
                        <th>vy (m/s)</th>
                    </tr>
            """);
    }

    public List<BigDecimal[]> simulateMotion(BigDecimal initialVelocityX, BigDecimal initialVelocityY) {
        this.startTime = Instant.now(); // Start time of simulation
        this.initialVelocityX = initialVelocityX;
        this.initialVelocityY = initialVelocityY;
        
        List<BigDecimal[]> positions = new ArrayList<>();
        BigDecimal x = BigDecimal.ZERO;
        BigDecimal y = BigDecimal.ZERO;
        BigDecimal vx = initialVelocityX;
        BigDecimal vy = initialVelocityY;

        // Add the initial position to HTML
        addCalculationStep(0, x, y, vx, vy);

        while (y.compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal ax = vx.negate().multiply(k).setScale(scale, RoundingMode.HALF_UP);
            BigDecimal ay = vy.negate().multiply(k).subtract(g).setScale(scale, RoundingMode.HALF_UP);

            vx = vx.add(ax.multiply(deltaTime)).setScale(scale, RoundingMode.HALF_UP);
            vy = vy.add(ay.multiply(deltaTime)).setScale(scale, RoundingMode.HALF_UP);

            x = x.add(vx.multiply(deltaTime)).setScale(scale, RoundingMode.HALF_UP);
            y = y.add(vy.multiply(deltaTime)).setScale(scale, RoundingMode.HALF_UP);

            if (y.compareTo(BigDecimal.ZERO) < 0) {
                break;
            }

            addCalculationStep(++totalSteps, x, y, vx, vy); // Increment and log each step
            positions.add(new BigDecimal[]{x, y});
        }

        this.endTime = Instant.now(); // End time of simulation
        finishHtml(); // Include run statistics in the HTML content
        return positions;
    }

    private void addCalculationStep(int iteration, BigDecimal x, BigDecimal y, BigDecimal vx, BigDecimal vy) {
        this.calculationSteps.append(String.format("""
                <tr>
                    <td>%d</td>
                    <td>%s</td>
                    <td>%s</td>
                    <td>%s</td>
                    <td>%s</td>
                </tr>
                """, iteration, x.setScale(scale, RoundingMode.HALF_UP).toPlainString(), 
                    y.setScale(scale, RoundingMode.HALF_UP).toPlainString(), 
                    vx.setScale(scale, RoundingMode.HALF_UP).toPlainString(), 
                    vy.setScale(scale, RoundingMode.HALF_UP).toPlainString()));
    }

    private void finishHtml() {
        Duration duration = Duration.between(startTime, endTime);
        this.calculationSteps.append("""
                </table>
                <h3>Run Statistics</h3>
                <ul>
                    <li>Initial velocity in X direction: %s m/s</li>
                    <li>Initial velocity in Y direction: %s m/s</li>
                    <li>Air resistance proportionality constant (k): %s</li>
                    <li>Time step (delta time): %s s</li>
                    <li>Rounding scale: %d decimal places</li>
                    <li>Total steps: %d</li>
                    <li>Duration of run: %d milliseconds</li>
                </ul>
            </body>
            </html>
            """.formatted(
                    initialVelocityX.toPlainString(),
                    initialVelocityY.toPlainString(),
                    k.toPlainString(),
                    deltaTime.toPlainString(),
                    scale,
                    totalSteps,
                    duration.toMillis()
            ));
    }

    public String getCalculationSteps() {
        return calculationSteps.toString();
    }
}
