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
import java.util.Scanner;;

public class ExpenseTrackerMain {
    public static void main(String[] args) {
        String userDataFilePath = ".\\Expense tracker\\data\\usr_data.txt";
        String expenseRecordsFilePath = ".\\Expense tracker\\data\\expense_records.txt";
        String incomeRecordsFilePath = ".\\Expense tracker\\data\\income_record.txt";
        ExpenseTracker tracker = new ExpenseTracker(userDataFilePath, expenseRecordsFilePath, incomeRecordsFilePath);

    }

}
