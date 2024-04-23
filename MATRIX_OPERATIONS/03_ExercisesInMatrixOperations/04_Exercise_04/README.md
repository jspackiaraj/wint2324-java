### Programming Assignment: 3D Rotation of a Line Segment

#### Objective:
Develop a Java program (`App.java`) to perform a 3D rotation on a line segment based on specified rotation angles around the X, Y, and Z axes. The program should read the initial coordinates of the line segment and the rotation angles (in degrees) from a file, apply the rotation matrices, and print the new coordinates of the rotated line segment.

#### Assignment Details:

##### Part A: Read Input Data
1. **Input File:**
   - Use the `MatrixFileReader` class to load line endpoint coordinates (`x1, y1, z1, x2, y2, z2`) and rotation angles (`alpha, beta, theta`) from `linecoordinates.txt`.

##### Part B: Setup Rotation Matrices and Perform Calculations
2. **Convert Angles from Degrees to Radians:**
   - Implement a method in `App.java` to convert degrees to radians for each rotation angle since the Java Math functions require radians.

3. **Define and Apply Rotation Matrices:**
   - Calculate the rotation matrices for the X, Y, and Z axes using the converted angles.
   - Combine these matrices into a single rotation matrix assuming rotations are applied in the order: Z, Y, X (common convention in 3D graphics).
   - Apply this rotation matrix to each endpoint of the line to calculate the new coordinates.

##### Part C: Output the Results
4. **Print the New Coordinates:**
   - Use the `MatrixPrinter` class to output the new coordinates of the rotated line segment's endpoints.

#### Example Input (`linecoordinates.txt`):
```plaintext
0, 0, 0, 0, 1, 0, 90, 0, 0
```
This input specifies a line segment from `(0, 0, 0)` to `(0, 1, 0)` with a 90-degree rotation about the X-axis, and no rotation about the Y or Z axes.

#### Explanation of Transformations:

The provided rotation angles are applied to a line segment using the following ASCII-style representation of rotation matrices:

- **Rotation around the X-axis (Roll) by 90 degrees:**
  ```
  R_x(90°) = |  1  0  0 |
             |  0  0 -1 |
             |  0  1  0 |
  ```
  This rotation moves points in the YZ-plane; Y becomes Z and Z becomes -Y.

- **No rotation around the Y-axis (Pitch) and Z-axis (Yaw):**
  ```
  R_y = R_z = |  1  0  0 |
              |  0  1  0 |
              |  0  0  1 |
  ```

After applying these rotations, the initial endpoint \(P_2\) at (0, 1, 0) transforms to (0, 0, 1), showing that it has moved along the Z-axis due to the rotation about the X-axis.

#### Expected Output:

The program should output the following to indicate the new position of the line segment after rotation:
```
Rotated Line Endpoints:
0.0
0.0
0.0
0.0
0.0
1.0
```

This output reflects that the second endpoint of the line has rotated into the position `(0, 0, 1)`, confirming the effect of the 90-degree rotation about the X-axis as calculated.

---

**Note:**
Although the number of lines of code may seem long in `App.java`, the lines of code are broken up to ensure readability and clear understanding of the steps involved in the process.