package E_Commerce.e_commerce.CartItem;

import E_Commerce.e_commerce.Product.Modelecommerce;
import E_Commerce.e_commerce.Product.Repositoryecommerce;
import E_Commerce.e_commerce.User.Modeluser;
import E_Commerce.e_commerce.User.Repouser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Servicecartitem {
    private Repocartitem repocart;
    private Repositoryecommerce productrepo;
    private Repouser userrepo;
    public Servicecartitem(Repocartitem repocart,Repositoryecommerce productrepo,Repouser userrepo) {
        this.repocart = repocart;
        this.productrepo=productrepo;
        this.userrepo=userrepo;
    }

    public Modelcartitem addtocart(Long userid,Long productid,int quantity)
    {
        Modeluser userobj =userrepo.findById(userid).orElseThrow(()-> new RuntimeException("User not found!"));
        Modelecommerce prodobj = productrepo.findById(productid).orElseThrow(()->new RuntimeException("Product not found!") );

        Modelcartitem cartitem = new Modelcartitem();
        cartitem.setModeluser(userobj);
        cartitem.setProdid(prodobj);
        cartitem.setQuantity(quantity);
return repocart.save(cartitem);

    }
public List<Modelcartitem> getcartitembyuser(Long userid)
{
 Modeluser user = userrepo.findById(userid).orElseThrow(()-> new RuntimeException("Id not found!"));
 return repocart.findByModeluser(user);
}

    public void removeFromCart(Long id) {
       repocart.deleteById(id);
    }

    public Modelcartitem updateitem(Long id,int quantity)
    {
        Modelcartitem cartitem= repocart.findById(id).orElseThrow(()-> new RuntimeException("Userid not found!"));
   cartitem.setQuantity(quantity);
   return repocart.save(cartitem);

    }
}
