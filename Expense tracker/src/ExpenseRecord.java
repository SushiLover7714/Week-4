public class ExpenseRecord {
    private String category;
    private String date;
    private float price;

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

    public void displayExpenseRecord() {
        System.out.println(category);
        System.out.println(date);
        System.out.println(price);
    }

}
