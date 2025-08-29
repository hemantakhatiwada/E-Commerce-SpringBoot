package E_Commerce.e_commerce.Orders;

import E_Commerce.e_commerce.Product.Modelecommerce;
import jakarta.persistence.*;


@Entity
@Table(name="order_items")
public class Orderitems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Ordermodel order;

    @ManyToOne @JoinColumn(name = "product_id", nullable = false)
    private Modelecommerce product;

    private int quantity;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordermodel getOrder() {
        return order;
    }

    public void setOrder(Ordermodel order) {
        this.order = order;
    }

    public Modelecommerce getProduct() {
        return product;
    }

    public void setProduct(Modelecommerce product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
