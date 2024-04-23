import java.util.Scanner;

public class ASCIICode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char character = scanner.next().charAt(0);
        int asciiCode = (int) character;
        System.out.println("The ASCII code of '" + character + "' is: " + asciiCode);
    }
}