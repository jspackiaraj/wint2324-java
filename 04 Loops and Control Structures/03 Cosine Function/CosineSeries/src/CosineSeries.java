public class CosineSeries {
    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double calculateCosine(double x) {
        double sum = 1.0; // The start value of the series is 1, hence we use 1. Compare it with the Sine series solution.
        double term = 1.0;
        double numerator = 1.0; // We start the second term on x^2 here. Compare it with the Sine series solution.
        double nFactorial = 1.0;
        double previousSum = 0.0;
        double difference = 0.0;
        int n = 0; // The series for factorial is even, hence we start with 0. Compare it with the Sine series solution.
        int sign = 1;

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
        } while (difference > 0.0001);
        return sum;
    }
}
