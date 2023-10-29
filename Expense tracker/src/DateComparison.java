import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String date1;
        String date2;
        String[] date1Arr;
        String[] date2Arr;
        System.out.print("Enter first date(d/m/yyyy): ");
        date1 = input.nextLine();
        System.out.print("Enter second date(d/m/yyyy): ");
        date2 = input.nextLine();
        date1Arr = date1.split("/");
        int date1Day = Integer.parseInt(date1Arr[0]);
        int date1Month = Integer.parseInt(date1Arr[1]);
        int date1Year = Integer.parseInt(date1Arr[2]);
        date2Arr = date2.split("/");
        int date2Day = Integer.parseInt(date2Arr[0]);
        int date2Month = Integer.parseInt(date2Arr[1]);
        int date2Year = Integer.parseInt(date2Arr[2]);

    }
}
