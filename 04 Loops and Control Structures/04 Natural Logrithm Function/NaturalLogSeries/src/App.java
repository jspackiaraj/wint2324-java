import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of x (-1 < x <= 1): ");
        double x = scanner.nextDouble();
        scanner.close();

        if (x <= -1 || x > 1) {
            System.out.println("The value of x must be in the range -1 < x <= 1.");
        } else {
            double result = NaturalLogSeries.calculateNaturalLog(x);
            System.out.println("Natural log of (1+" + x + ") is approximately: " + result);
        }
    }
}
