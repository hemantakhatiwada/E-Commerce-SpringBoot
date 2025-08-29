package E_Commerce.e_commerce.CartItem;

import E_Commerce.e_commerce.Product.Modelecommerce;
import E_Commerce.e_commerce.User.Modeluser;
import E_Commerce.e_commerce.User.Serviceuser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class Controllercartitem {
    private Servicecartitem servicecart;

    public Controllercartitem(Servicecartitem servicecart) {
        this.servicecart = servicecart;
    }
    @PostMapping("/addtocart")
    public Modelcartitem addtocart(@RequestParam Long userid,@RequestParam Long productid,@RequestParam  int quantity)
    {
        return servicecart.addtocart(userid,productid,quantity);

    }
    @GetMapping("/getcartitembyuser/{id}")
    public List<Modelcartitem> getcartitembyuser(Long userid)
    {
return servicecart.getcartitembyuser(userid);
    }
@DeleteMapping("/delete/{id}")
    public String removeFromCart(@PathVariable  Long id) {
       servicecart.removeFromCart(id);
       return "Removed from cart! "+id;
    }
    @PutMapping("/update/{id}")
    public Modelcartitem updateitem(@RequestParam Long userid,@RequestParam int quantity)
    {
       return servicecart.updateitem(userid,quantity);

    }

}
