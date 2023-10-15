public class ExpenseRecord {
    private String category;
    private String date;
    private float price;

    public ExpenseRecord(String category, String date, float price) {
        this.category = category;
        this.date = date;
        this.price = price;
    }

    public void displayExpenseRecord() {
        System.out.println(category);
        System.out.println(date);
        System.out.println(price);
    }
}
