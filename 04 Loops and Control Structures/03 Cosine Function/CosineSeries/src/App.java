import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            FileOutputManager.initialize(); // Initialize the file output manager
            
            System.out.print("Enter the value of x (in radians): ");
            Scanner scanner = new Scanner(System.in);
            double x = scanner.nextDouble();
            FileOutputManager.print("<p>Enter the value of x (in radians): " + x); // Replace System.out with FileOutputManager.print
            double result = CosineSeries.calculateCosine(x);
            System.out.println("cos(" + x + ") = " + result);
            FileOutputManager.println("<br />cos(" + x + ") = " + result + "<br /><br /></p>"); // Replace System.out.println with FileOutputManager.println
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
