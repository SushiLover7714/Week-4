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
}
