public class ArctanSeries {

    public static double calculateArctan(double x) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("Value of x must be in the range -1 <= x <= 1.");
        }

        double sum = x; // Initialize sum with the first term of the series, which is x
        double term = x; // The first term of the series
        double difference;
        int n = 1;

        do {
            term *= x * x; // Square x for the next term's numerator
            term = -term / (n + 2); // Alternate the sign and adjust the denominator
            sum += term; // Add the new term to the sum
            difference = term > 0 ? term : -term; // Calculate the absolute difference without using Math.abs()
            n += 2; // Increment n by 2 for the next term
        } while (difference >= 0.0001);

        return sum;
    }
}