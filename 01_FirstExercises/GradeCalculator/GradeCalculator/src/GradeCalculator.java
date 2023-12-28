import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter exam scores
        System.out.print("Enter the score for Exam 1: ");
        double exam1 = scanner.nextDouble();

        System.out.print("Enter the score for Exam 2: ");
        double exam2 = scanner.nextDouble();

        System.out.print("Enter the score for Exam 3: ");
        double exam3 = scanner.nextDouble();

        // Calculate the average score
        double averageScore = (exam1 + exam2 + exam3) / 3.0;

        // Determine the final grade (you can define your grading criteria here)
        String finalGrade;
        if (averageScore >= 90) {
            finalGrade = "A";
        } else if (averageScore >= 80) {
            finalGrade = "B";
        } else if (averageScore >= 70) {
            finalGrade = "C";
        } else if (averageScore >= 60) {
            finalGrade = "D";
        } else {
            finalGrade = "F";
        }

        // Display the final grade
        System.out.println("The final grade is: " + finalGrade);

        // Close the scanner
        scanner.close();
    }
}
