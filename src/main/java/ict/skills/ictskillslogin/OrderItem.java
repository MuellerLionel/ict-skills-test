package ict.skills.ictskillslogin;

public class OrderItem {
    private Integer count;
    private String name;
    private Float price;

    public OrderItem(Integer count, String name, Float price) {
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPrice() {
        return price * count;
    }

}
