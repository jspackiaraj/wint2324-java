
### Programming Assignment: Solving Systems of Linear Equations Using Matrix Operations

#### Objective:
Develop a Java program (`App.java`) that reads a set of linear equations formatted as an augmented matrix from a file, processes this data to solve the equations using matrix inversion, and prints the solution. The solution should utilize the custom Java classes provided and demonstrate understanding of matrix operations.

#### Assignment Details:

##### Part A: Setup and Input
1. **Read the Augmented Matrix:**
   - Use the `MatrixFileReader` class to import an \(n \times (n+1)\) matrix from a file named `equations.csv`. This file should contain the coefficients of the variables followed by the constant terms for each equation, all separated by commas.

##### Part B: Matrix Manipulation
2. **Validate Matrix Format:**
   - Ensure the matrix has \(n + 1\) columns for \(n\) rows, confirming it's properly augmented.

3. **Extract Coefficients and Constants:**
   - Use logical indexing to divide the augmented matrix into:
     - A coefficient matrix \(A\) (first \(n\) columns).
     - A constants vector \(B\) (last column).

##### Part C: Solving the Equations
4. **Compute the Inverse of the Coefficient Matrix:**
   - Call `CalculateInverse.calculate(Matrix A)` to find the inverse of matrix \(A\).

5. **Calculate the Solution Vector:**
   - Employ `MatrixMultiplication.multiply(Matrix A, Matrix B)` to multiply the inverse of the coefficient matrix by the constants vector, yielding the solution vector \(X\).

##### Part D: Output the Results
6. **Display the Results:**
   - Output the solution vector \(X\) using the `MatrixPrinter.printMatrix(Matrix X)` method to print the results to the console.

##### Part E: Error Handling
7. **Handle Exceptions and Validate Input:**
   - Include error handling for file-not-found exceptions, incorrect matrix dimensions, and arithmetic errors (such as trying to invert a non-invertible matrix). Use appropriate error messages to guide correction.

#### Instructions:
- Implement the program in `App.java` using the methods and classes described.
- Thoroughly comment your code to explain your logic and the functions used.
- Ensure your program gracefully handles any errors and provides informative messages for debugging.

### Sample Equations for a 4x4 System


#### Given Equations:

1. **Equation 1:**
   \[ x_1 + 2x_2 + 3x_3 + 4x_4 = 20 \]
2. **Equation 2:**
   \[ 2x_1 + 3x_2 + 7x_3 + 8x_4 = 40 \]
3. **Equation 3:**
   \[ 3x_1 + 5x_2 + 12x_3 + 1x_4 = 30 \]
4. **Equation 4:**
   \[ 4x_1 + 11x_2 + 1x_3 + 3x_4 = 50 \]

This set of equations is designed to have a non-zero determinant when formed into a coefficient matrix. The variation in coefficients, especially in the third and fourth equations, helps ensure that the matrix columns are not linearly dependent.

### Corresponding `equations.csv` File Content:

To use these equations in your program, format them into a CSV file like this:

```plaintext
1,2,3,4,20
2,3,7,8,40
3,5,12,1,30
4,11,1,3,50
```

Each row represents one equation with the coefficients for \(x_1, x_2, x_3,\) and \(x_4\) followed by the constant on the right side of the equation.

### Using These Equations in `App.java`

Ensure your `App.java` is set up to read this CSV file, extract the necessary matrices, and solve the equations using your matrix inversion method. Here is a brief reminder of how `App.java` could handle this:



### Additional Tips

- **Validate the Determinant:** Before applying the matrix inversion, you might want to check if the determinant of the coefficient matrix is indeed non-zero if your matrix classes support this calculation. This can prevent runtime errors related to non-invertible matrices.
- **Testing:** It's a good practice to test the application with various sets of equations to ensure that it handles different scenarios correctly, including those with zero and non-zero determinants.

