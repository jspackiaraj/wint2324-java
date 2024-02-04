public class NaturalLogSeries {

    public static double calculateNaturalLog(double x) {
        if (x <= -1 || x > 1) {
            throw new IllegalArgumentException("x must be in the range -1 < x <= 1");
        }
        
        double sum = 0.0; // Initialize sum of the series
        double term = x; // First term is x itself
        double previousSum = 0.0;
        double difference = 0.0;
        int n = 1;

        do {
            previousSum = sum; // Store the sum from the previous iteration
            sum += term; // Add the current term to the sum
            n++; // Increment n for the next term
            term = term * x / n; // Calculate the next term
            
            if (n % 2 == 0) { // Adjust the sign for even terms
                term = -term;
            }
            
            difference = sum - previousSum; // Calculate the difference
            if (difference < 0) { // Make the difference positive if it's negative
                difference = -difference;
            }
        } while (difference > 0.0001); // Continue until the difference is small enough
        
        return sum; // Return the sum, which is the approximation of ln(1+x)
    }
}
