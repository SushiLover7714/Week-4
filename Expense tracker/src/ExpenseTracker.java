import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ExpenseTracker {
    String userDataFilePath;
    String expenseRecordsFilePath;
    String incomeRecordsFilePath;

    public ExpenseTracker(String userDataFilePath, String expenseRecordsFilePath, String incomeRecordsFilePath) {
        this.userDataFilePath = userDataFilePath;
        this.expenseRecordsFilePath = expenseRecordsFilePath;
        this.incomeRecordsFilePath = incomeRecordsFilePath;
        User user = new User(userDataFilePath, expenseRecordsFilePath, incomeRecordsFilePath);
    }

    public int addIncome(float amount, String source) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the current date as a string
        String dateString = currentDate.format(formatter);
        String newIncomeRecordLine = source + ":" + String.valueOf(amount) + "," + dateString;
        try {
            FileWriter fileWriter = new FileWriter(incomeRecordsFilePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(newIncomeRecordLine);

            return 0;
        }

        catch (IOException e) {
            return 1;
        }
    }
}
