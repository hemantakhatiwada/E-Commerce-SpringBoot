package E_Commerce.e_commerce.Orders;

import E_Commerce.e_commerce.User.Modeluser;
import E_Commerce.e_commerce.User.Serviceuser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class Ordercontroller {

    public class OrderController {

        private final Orderservice orderService;
        private final Serviceuser serviceuser;

        public OrderController(Orderservice orderService, Serviceuser serviceuser) {
            this.orderService = orderService;
            this.serviceuser = serviceuser;
        }

        @PostMapping("/place/{userId}")
        public Ordermodel placeOrder(@PathVariable Long userId) {
            Modeluser user = serviceuser.getuserbyid(userId);
            return orderService.placeOrder(user);
        }

        @GetMapping("/user/{userId}")
        public List<Ordermodel> getUserOrders(@PathVariable Long userId) {
            Modeluser user = serviceuser.getuserbyid(userId);
            return orderService.getOrdersByUser(user);
        }
    }
}
