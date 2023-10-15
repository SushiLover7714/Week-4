public class IncomeRecord {
    private float balance;
    private String category;
    private String date;

    public IncomeRecord(float balance, String category, String date) {
        this.balance = balance;
        this.category = category;
        this.date = date;
    }

    public void displayIncomeRecord() {
        System.out.println(category);
        System.out.println(date);
        System.out.println(balance);
    }
}
