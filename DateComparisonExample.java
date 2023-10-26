import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparisonExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String startDateStr;
        String endDateStr;
        String dateStr;
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.print("Enter start date(dd/mm/yyyy): ");
        startDateStr = input.nextLine();
        System.out.print("Enter end date(dd/mm/yyyy): ");
        endDateStr = input.nextLine();
        System.out.print("Enter Date: ");
        dateStr = input.nextLine();
        // Parse the date strings into LocalDate objects

        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        LocalDate date = LocalDate.parse(dateStr, formatter);
        // Compare the dates
        if (date.isAfter(startDate) && date.isBefore(endDate)) {
            System.out.println("User input date is within date range");
        } else {
            System.out.println("User input date is not in date range");
        }
    }
}