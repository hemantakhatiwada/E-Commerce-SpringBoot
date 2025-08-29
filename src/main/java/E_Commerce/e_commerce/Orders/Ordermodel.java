package E_Commerce.e_commerce.Orders;

import E_Commerce.e_commerce.User.Modeluser;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="orders")
public class Ordermodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="users_id",nullable=false)
    private Modeluser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modeluser getUser() {
        return user;
    }

    public void setUser(Modeluser user) {
        this.user = user;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Orderitems> getItems() {
        return items;
    }

    public void setItems(List<Orderitems> items) {
        this.items = items;
    }

    @Column(name="total_amount")
    private Double totalamount;

    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orderitems> items;
}
