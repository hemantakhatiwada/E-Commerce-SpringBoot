package E_Commerce.e_commerce.Orders;

import E_Commerce.e_commerce.CartItem.Modelcartitem;
import E_Commerce.e_commerce.CartItem.Repocartitem;
import E_Commerce.e_commerce.User.Modeluser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderservice {
    private Orderrepo ordderrepo;
    private Repocartitem repocart;

    public Orderservice(Orderrepo ordderrepo, Repocartitem repocart) {
        this.ordderrepo = ordderrepo;
        this.repocart = repocart;
    }

    public Ordermodel placeOrder(Modeluser user) {
        List<Modelcartitem> cartItems = repocart.findByModeluser(user);
        double totalAmount = cartItems.stream()
                .mapToDouble(item -> item.getProdid().getPrice() * item.getQuantity())
                .sum();
        Ordermodel order = new Ordermodel();
        order.setUser(user);
        order.setTotalamount(totalAmount);
        order.setStatus("PENDING");

        List<Orderitems> orderItems = cartItems.stream().map(cartItem -> {
            Orderitems oi = new Orderitems();
            oi.setOrder(order);
            oi.setProduct(cartItem.getProdid());
            oi.setQuantity(cartItem.getQuantity());
            return oi;
        }).toList();
        order.setItems(orderItems);

        // Save order (cascades to items)
        Ordermodel savedOrder = ordderrepo.save(order);

        // Clear user cart after placing order
        repocart.deleteAll(cartItems);

        return savedOrder;
    }

    public List<Ordermodel> getOrdersByUser(Modeluser user) {
        return ordderrepo.findByUser(user);
    }
}
