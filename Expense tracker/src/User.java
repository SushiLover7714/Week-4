import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private float balance;
    public String name;
    ArrayList<ExpenseRecord> expenseRecords = new ArrayList<ExpenseRecord>();
    ArrayList<IncomeRecord> incomeRecords = new ArrayList<IncomeRecord>();

    public User(String userDataFilePath, String expenseRecordsFilePath, String incomeRecordsFilePath) {
        try {
            FileReader fileReader = new FileReader(userDataFilePath);
            BufferedReader reader = new BufferedReader(fileReader);
            this.balance = Float.parseFloat(reader.readLine());
            this.name = reader.readLine();
            reader.close();
            fileReader = new FileReader(expenseRecordsFilePath);
            reader = new BufferedReader(fileReader);
            String line;
            String category;
            String date;
            float price;
            String[] expenseRecordArr;
            ExpenseRecord expenseRecord;
            while ((line = reader.readLine()) != null) {
                expenseRecordArr = line.split("[:,]");
                category = expenseRecordArr[0];
                price = Float.parseFloat(expenseRecordArr[1]);
                date = expenseRecordArr[2];
                expenseRecord = new ExpenseRecord(category, date, price);
                expenseRecords.add(expenseRecord);
                //expenseRecord.displayExpenseRecord();
            }
            reader.close();
            fileReader = new FileReader(incomeRecordsFilePath);
            reader = new BufferedReader(fileReader);
            IncomeRecord incomeRecord;
            while ((line = reader.readLine()) != null) {
                expenseRecordArr = line.split("[:,]");
                category = expenseRecordArr[0];
                price = Float.parseFloat(expenseRecordArr[1]);
                date = expenseRecordArr[2];
                incomeRecord = new IncomeRecord(price, category, date);
                incomeRecords.add(incomeRecord);
                //incomeRecord.displayIncomeRecord();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUserInformation() {
        System.out.println(this.balance);
        System.out.println(this.name);
    }
}
