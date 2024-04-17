import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SineSeries {

    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double calculateSine(double x) throws IOException {
        String filePath = "SineSeriesTable.html";
        File file = new File(filePath);
        if (file.exists()) {
            file.delete(); // Delete the file if it exists
        }
        double sum = x;
        double term = 1.0;
        double numerator = x;
        double nFactorial = 1.0;
        double previousSum = 0.0;
        double difference = 0.0;
        int n = 1;
        int sign = 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("<table border='1'><tr><th>Iteration (n)</th><th>numerator</th><th>nFactorial</th>" +
                         "<th>term</th><th>previousSum</th><th>sum</th><th>difference</th><th>sign</th></tr>" + '\n');
            do {
            previousSum = sum;
            numerator = numerator * x * x;
            n += 2;
            sign *= -1;
            nFactorial = factorial(n); 
            term = sign * numerator / nFactorial;
            sum += term;
            difference = sum - previousSum;
            if (difference < 0.0){
                difference = -1.0 * difference;
            }
                writer.write(String.format("<tr><td>%d</td><td>%f</td><td>%f</td><td>%f</td><td>%f</td><td>%f</td><td>%f</td><td>%d</td></tr>\n",
                                           n, numerator, nFactorial, term, previousSum, sum, difference, sign));

            } while (difference > 0.0001);

            writer.write("</table>");
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            double x = Math.PI / 2; // Example usage
            calculateSine(x);
            System.out.println("Sine series table has been written to SineSeriesTable.html");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
