package th.ku.Bookstore;

public class Book {
    private int id;
    private String name;
    private double price;

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        String s = "th.ku.Bookstore.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + '}';
        return s;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
}
