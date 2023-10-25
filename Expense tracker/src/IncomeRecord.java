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

 public ExpenseRecord(String category, String date, float price) {
        this.category = category;
        this.date = date;
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDate() {
        return this.date;
    }

    public float getPrice() {
        return this.price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(float price) {
        this.price = price;
    }
