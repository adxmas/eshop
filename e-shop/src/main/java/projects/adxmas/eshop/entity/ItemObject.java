package projects.adxmas.eshop.entity;


import javax.persistence.*;

@Entity
public class ItemObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String brand;
    private String type;
    private double price;
    private String imgUrl;
    private int amountLeft;

    public ItemObject(int id, String name, String brand, String type, Double price, String imgUrl, int amountLeft) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.imgUrl = imgUrl;
        this.amountLeft = amountLeft;
    }

    public ItemObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }
}
