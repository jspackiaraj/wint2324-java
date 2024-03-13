import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of x (-1 <= x <= 1): ");
        double x = scanner.nextDouble();
        scanner.close();
        try {
            double result = ArctanSeries.calculateArctan(x);
            System.out.printf("arctan(%f) = %f\n", x, result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
