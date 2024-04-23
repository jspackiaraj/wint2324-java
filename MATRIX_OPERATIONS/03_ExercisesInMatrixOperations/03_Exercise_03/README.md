### Question - 01 Matrix Operations
You have a set of class files that can be used to perform various matrix operations. 
#### Part A - Matrix Display
**Objective**: Write a Java program named `App.java`, which uses the supplied class files and performs the following operations:

1. **Read a Matrix:**
   - Utilize the `MatrixFileReader` class to read matrix data from a CSV file named "matrix.txt". The CSV file contains numerical data representing the matrix elements where each row of the matrix is on a separate line, and each element within the row is separated by a comma (`,`). For example, a 2x2 matrix would be represented as follows in "matrix.txt":
     ```
     1.0,2.0
     3.0,4.0
     ```
   - Assume "matrix.txt" is correctly formatted and located in the same directory as `App.java`.

2. **Print the Matrix:**
   - Use the `MatrixPrinter` class to display the matrix data read from the file on the console.

Ensure that your program in `App.java`, excluding JavaDoc comments and blank lines, does not exceed 15 lines of code.

#### Part B - Matrix Scalar Multiplication
**Objective**: Extend the `App.java` program from Part A by incorporating the following functionality:

3. **Matrix Scalar Multiplication:**
   - After displaying the original matrix, prompt the user to input a scalar value from the console.
   - Multiply the original matrix by the scalar using the `MultiplyMatrixByScalar` class.

4. **Output the Resulting Matrix:**
   - Print the resulting matrix (after scalar multiplication) using the `MatrixPrinter` class.

The complete program must still adhere to the 15-line code limit (excluding JavaDoc comments and blank lines).

### Solution to the Problem

Below is the Java code for `App.java` that meets all the specified requirements in the question:

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Matrix matrix = MatrixFileReader.read("matrix.txt"); // Read matrix from CSV file
        MatrixPrinter.print(matrix);                         // Print the original matrix
        
        Scanner scanner = new Scanner(System.in);            // Scanner for user input
        System.out.print("Enter a scalar value: ");          // Prompt for scalar input
        double scalar = scanner.nextDouble();                // Read scalar value from console
        
        Matrix scaledMatrix = MultiplyMatrixByScalar.multiply(matrix, scalar); // Scale matrix
        MatrixPrinter.print(scaledMatrix);                   // Print scaled matrix
        scanner.close();                                     // Close scanner to prevent leaks
    }
}
```

#### Explanation
- **Lines 1-3:** Necessary imports for the functionality (Scanner for input).
- **Line 5:** The `main` method - entry point of the program.
- **Line 6:** Reads the matrix from the specified CSV file "matrix.txt".
- **Line 7:** Prints the original matrix to standard output.
- **Lines 9-10:** Creates a Scanner for reading console input and prompts the user.
- **Line 11:** Captures the scalar value entered by the user.
- **Line 13:** Multiplies the original matrix by the scalar.
- **Line 14:** Prints the resulting matrix after multiplication.
- **Line 15:** Closes the Scanner to free up resources.

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
