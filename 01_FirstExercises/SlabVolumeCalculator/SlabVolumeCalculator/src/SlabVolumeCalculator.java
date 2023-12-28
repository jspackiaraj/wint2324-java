import java.util.Scanner;

public class SlabVolumeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the length of the concrete slab (in meters): ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the concrete slab (in meters): ");
        double width = scanner.nextDouble();

        System.out.print("Enter the thickness of the concrete slab (in meters): ");
        double thickness = scanner.nextDouble();

        // Calculate the volume of the concrete slab
        double volume = length * width * thickness;

        // Display the result
        System.out.println("The volume of the concrete slab is: " + volume + " cubic meters");

        // Close the scanner
        scanner.close();
    }
}
