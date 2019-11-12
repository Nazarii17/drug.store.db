package nazarii.tkachuk.com.entities;

//import nazarii.tkachuk.com.enums.CSVFormats;

import java.math.BigDecimal;

public class Product extends EntityID /*implements CSVSerializable*/ {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String info;
    private Integer discount;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(String name, BigDecimal price, String info) {
        this.id = null;
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public Product(String name, BigDecimal price, String info, Integer discount) {
        this.id = null;
        this.name = name;
        this.price = price;
        this.info = info;
        this.discount = discount;
    }

    public Product(Integer id, String name, BigDecimal price, String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public Product(Integer id, String name, BigDecimal price, String info, Integer discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID of the product = " + id +
                ", Name = '" + name + '\'' +
                ", Price = " + price + "$" +
                ", Discount = : '" + discount + "% '" +
                ", \nInformation: '" + info + " '" +
                '}';
    }
//    @Override
//    public String toCSVFormattedString() {
//        return String.format(CSVFormats.PRODUCT.getFormatValue(), id + ",", name + ",", price + ",", info);
//    }
//
//    @Override
//    public String toCSVString() {
//        return id + "," + name + "," +  price + "," + info+"\n";
//    }
}
