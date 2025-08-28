package E_Commerce.e_commerce.Product;

import jakarta.persistence.*;

@Entity
@Table(name="Productodelecommerce")
public class Modelecommerce {
public Modelecommerce()
{

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageurl;
    private String description;
    private String name;
    private double price;

    public Modelecommerce(String name, double price, String imageurl, String description) {

        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
