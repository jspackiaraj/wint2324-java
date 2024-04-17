import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class EventScheduler {

    // Method to calculate the next occurrences of a given day of the week
    public void scheduleEvents(DayOfWeek day, int numberOfWeeks) {
        LocalDate today = LocalDate.now();
        // Find the next occurrence of the specified day
        LocalDate nextEvent = today.with(TemporalAdjusters.nextOrSame(day));

        // Print the dates for the number of weeks specified
        System.out.println("Upcoming " + day + "s for the next " + numberOfWeeks + " weeks:");
        for (int i = 0; i < numberOfWeeks; i++) {
            System.out.println(nextEvent);
            nextEvent = nextEvent.plusWeeks(1); // Increment to the next week
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the day of the week
        System.out.println("Enter the day of the week (e.g., MONDAY, TUESDAY, etc.):");
        String dayString = scanner.nextLine().toUpperCase();
        DayOfWeek day = DayOfWeek.valueOf(dayString);

        // Get user input for the number of weeks
        System.out.println("Enter the number of weeks:");
        int numberOfWeeks = scanner.nextInt();

        // Create an instance of EventScheduler and call the scheduleEvents method
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvents(day, numberOfWeeks);

        scanner.close();
    }
}
