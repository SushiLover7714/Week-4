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
        float price;
        float amount;
        String source;
        int status;
        String userDataFilePath = ".\\Expense tracker\\data\\usr_data.txt";
        String expenseRecordsFilePath = ".\\Expense tracker\\data\\expense_records.txt";
        String incomeRecordsFilePath = ".\\Expense tracker\\data\\income_record.txt";
        ExpenseTracker tracker = new ExpenseTracker(userDataFilePath, expenseRecordsFilePath, incomeRecordsFilePath);
        while(true){
        System.out.println("1. Add income ");
        System.out.println("2. Add expense ");
        System.out.println("3. View expense breakdown by % ");
        System.out.println("4. View income breaker by % ");
        System.out.println("5: View expense records within date range ");
        System.out.println("6. View income roecords within date range ");
        System.out.println("7. Exit ");
        System.out.print("Enter option: ");
        option = input.nextInt();
        switch (option) {

            case 1:
                input.nextLine();
                System.out.print("Enter amount: ");
                amount = input.nextFloat();
                input.nextLine();
                System.out.print("Enter source: ");
                source = input.nextLine();
                status = tracker.addIncome(amount, source);
                if (status == 0) {
                    System.out.println("Operation Successful!");
                } else if (status == 1) {
                    System.out.println("Operation not successful");
                }

                break;

            case 2:
                input.nextLine();
                System.out.print("Enter Price: ");
                price = input.nextFloat();
                input.nextLine();
                System.out.print("Enter source: ");
                source = input.nextLine();
                status = tracker.addExpense(price, source);
                if (status == 0) {
                    System.out.println("Operation Successful!");
                } else if (status == 1) {
                    System.out.println("Operation not successful");
                }
                break;

            case 3:
                tracker.viewExpensePercentage();
                break;

            case 4:
                tracker.viewIncomePercentage();
                break;

            case 5:
                input.nextLine();
                String startDate;
                String endDate;
                System.out.print("Enter start date: ");
                startDate = input.nextLine();
                System.out.print("Enter end date: ");
                endDate = input.nextLine();
                tracker.viewExpenseRecordWithinDateRange(startDate, endDate);
                break;

            case 6:
                input.nextLine();
                String incomeStartDate;
                String incomeEndDate;
                System.out.print("Enter start date: ");
                incomeStartDate = input.nextLine();
                System.out.print("Enter end date: ");
                incomeEndDate = input.nextLine();
                tracker.viewIncomeRecordWithinDateRange(incomeStartDate, incomeEndDate);
                break;

            case 7:
                System.exit(0);
        }
    }
    }

}
