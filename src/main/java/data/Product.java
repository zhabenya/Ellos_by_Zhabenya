package data;

/**
 * Created by zhabenya on 03.02.16.
 */
public class Product {

    private String id;
    private String name;
    private String color;
    private int price;
    private int size;
    private String currency;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", currency='" + currency + '\'' +
                '}';
    }

}
