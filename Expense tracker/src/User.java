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
    ArrayList<ExpenseRecord> expenseRecords;
    ArrayList<IncomeRecord> incomeRecords;

    public User(String userDataFilePath) {
        try {
            FileReader fileReader = new FileReader(userDataFilePath);
            BufferedReader reader = new BufferedReader(fileReader);
            this.balance = Float.parseFloat(reader.readLine());
            this.name = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUserInformation() {
        System.out.println(this.balance);
        System.out.println(this.name);
    }
}
