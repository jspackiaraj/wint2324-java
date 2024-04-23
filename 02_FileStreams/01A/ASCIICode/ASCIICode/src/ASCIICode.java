import java.util.Scanner;

public class ASCIICode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char character = scanner.next().charAt(0);
        int asciiCode = (int) character;
        System.out.println("The ASCII code of '" + character + "' is: " + asciiCode);
        // I am getting an error that the scanner object is
        // not closed, and I am going to close it in the line
        // below. In this case, there is no other use for the
        // scanner class and it is safe. However, if any other 
        // part of your program needs it and you closeit, your
        // application could potentially crash without you knowing.
        scanner.close();
    }
}