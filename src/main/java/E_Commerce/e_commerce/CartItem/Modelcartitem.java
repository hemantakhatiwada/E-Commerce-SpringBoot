package E_Commerce.e_commerce.CartItem;

import E_Commerce.e_commerce.Product.Modelecommerce;
import E_Commerce.e_commerce.User.Modeluser;
import jakarta.persistence.*;

@Entity
@Table(name="cart_items")
public class Modelcartitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Modeluser modeluser;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Modelecommerce prodid;

    public Modelcartitem() {
    }

    public Modelcartitem(  Modeluser modeluser,Modelecommerce prodid,int quantity) {
       this.modeluser=modeluser;
       this.prodid=prodid;

        this.quantity = quantity;
    }


    public Modeluser getModeluser() {
        return modeluser;
    }

    public void setModeluser(Modeluser modeluser) {
        this.modeluser = modeluser;
    }

    public Modelecommerce getProdid() {
        return prodid;
    }

    public void setProdid(Modelecommerce prodid) {
        this.prodid = prodid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
