import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExpenseTrackerMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        String userDataFilePath = ".\\Expense tracker\\data\\usr_data.txt";
        String expenseRecordsFilePath = ".\\Expense tracker\\data\\expense_records.txt";
        String incomeRecordsFilePath = ".\\Expense tracker\\data\\income_record.txt";
        ExpenseTracker tracker = new ExpenseTracker(userDataFilePath, expenseRecordsFilePath, incomeRecordsFilePath);
        System.out.println("1. Add income: ");
        System.out.println("2. Add expense: ");
        System.out.println("3. Check bank statistics: ");
        System.out.println("4. Exit: ");
        System.out.print("Enter option: ");
        option = input.nextInt();
        switch (option) {

            case 1:
                input.nextLine();
                System.out.print("Enter amount: ");
                float amount = input.nextFloat();
                input.nextLine();
                System.out.print("Enter source: ");
                String source = input.nextLine();
                int status = tracker.addIncome(amount, source);
                if (status == 0) {
                    System.out.println("Operation Successful!");
                } else if (status == 1) {
                    System.out.println("Operation not successful");
                }

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;
        }
    }

}
