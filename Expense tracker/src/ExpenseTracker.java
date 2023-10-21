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
    User user;

    public ExpenseTracker(String userDataFilePath, String expenseRecordsFilePath, String incomeRecordsFilePath) {
        this.userDataFilePath = userDataFilePath;
        this.expenseRecordsFilePath = expenseRecordsFilePath;
        this.incomeRecordsFilePath = incomeRecordsFilePath;
        this.user = new User(userDataFilePath, expenseRecordsFilePath, incomeRecordsFilePath);
    }

    public int addIncome(float amount, String source) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the current date as a string
        String dateString = currentDate.format(formatter);
        String newIncomeRecordLine = "\n" + source + ":" + String.valueOf(amount) + "," + dateString;
        System.out.println(newIncomeRecordLine);
        try {
            FileWriter fileWriter = new FileWriter(incomeRecordsFilePath, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(newIncomeRecordLine);
            writer.close();
            float balance = this.user.getBalance();
            String name = this.user.getName();
            balance += amount;
            String userData = String.valueOf(balance) + "\n" + name;
            fileWriter = new FileWriter(userDataFilePath, false);
            writer = new BufferedWriter(fileWriter);
            writer.write(userData);
            writer.close();
            return 0;
        }

        catch (IOException e) {
            return 1;
        }
    }

    public int addExpense(float price, String source) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = currentDate.format(formatter);
        String newIncomeRecordLine = "\n" + source + ":" + String.valueOf(price) + "," + dateString;
        System.out.println(newIncomeRecordLine);
        try {
            FileWriter fileWriter = new FileWriter(expenseRecordsFilePath, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(newIncomeRecordLine);
            writer.close();
            float balance = this.user.getBalance();
            String name = this.user.getName();
            balance -= price;
            String userData = String.valueOf(balance) + "\n" + name;
            fileWriter = new FileWriter(userDataFilePath);
            writer = new BufferedWriter(fileWriter);
            writer.write(userData);
            writer.close();
            return 0;
        } catch (IOException e) {
            return 1;
        }
    }

    public void viewExpensePercentage() {
        String category;
        float price;
        String date;
        String line;
        String[] expenseRecordArr;
        ArrayList<ExpenseRecord> expenseRecords = new ArrayList<ExpenseRecord>();
        try {
            FileReader fileReader = new FileReader(expenseRecordsFilePath);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                expenseRecordArr = line.split("[:,]");
                category = expenseRecordArr[0];
                price = Float.parseFloat(expenseRecordArr[1]);
                date = expenseRecordArr[2];
                expenseRecords.add(new ExpenseRecord(category, date, price));
            }
            ArrayList<String> categoryList = new ArrayList<String>();
            for (int i = 0; i < expenseRecords.size(); i++) {
                categoryList.add(expenseRecords.get(i).getCategory());
            }
            ArrayList<String> uniqueCategoryList = new ArrayList<>();
            uniqueCategoryList = getUniqueCategories(categoryList);
            float totalExpense = 0.0f;
            float categoryExpense = 0.0f;
            for (int i = 0; i < expenseRecords.size(); i++) {
                totalExpense += expenseRecords.get(i).getPrice();
            }
            for (int i = 0; i < uniqueCategoryList.size(); i++) {
                categoryExpense = 0.0f;
                for (int j = 0; j < expenseRecords.size(); i++) {
                    if (uniqueCategoryList.get(i).equalsIgnoreCase(expenseRecords.get(j).getCategory())) {
                        categoryExpense += expenseRecords.get(j).getPrice();
                    }
                }
                System.out
                        .println(uniqueCategoryList.get(i) + " : " + ((categoryExpense / totalExpense) * 100) + " % ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUniqueCategories(ArrayList<String> categoryList) {
        String category;
        boolean isUnique;
        ArrayList<String> uniqueCategoryList = new ArrayList<String>();
        uniqueCategoryList.add(categoryList.get(0));
        for (int i = 0; i < categoryList.size(); i++) {
            category = categoryList.get(i);
            isUnique = true;
            for (int j = 0; j < uniqueCategoryList.size(); j++) {
                if (category.equalsIgnoreCase(uniqueCategoryList.get(j))) {
                    isUnique = false;
                    break;
                }
                if (isUnique == true) {
                    uniqueCategoryList.add(category);
                }
            }
        }
        return uniqueCategoryList;
    }
}
