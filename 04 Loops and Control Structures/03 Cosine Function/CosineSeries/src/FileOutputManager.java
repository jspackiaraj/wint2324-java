import java.io.*;

public class FileOutputManager {
    private static final String FILE_NAME = "consoleOutput.txt";
    private static int runCount = 0;
    
    public static void initialize() throws IOException {
        boolean fileExists = new File(FILE_NAME).exists();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
        if (!fileExists) {
            // File is created for the first time; no need for a run comment
            out.println("<div class=\"consoleOutput\">");
        } else {
            runCount++;
            out.println("<!-- Run " + runCount + " --><span style=\"color: grey;\">Run " + runCount + "</span>");
        }
        out.close();
    }
    
    public static void print(String message) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
        out.print(message);
        out.close(); // Close the writer to flush the contents
    }
    
    public static void println(String message) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
        out.println(message);
        out.close(); // Close the writer to flush the contents
    }
}
