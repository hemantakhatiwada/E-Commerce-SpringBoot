package E_Commerce.e_commerce.CartItem;

import E_Commerce.e_commerce.Product.Modelecommerce;
import E_Commerce.e_commerce.Product.Repositoryecommerce;
import E_Commerce.e_commerce.User.Modeluser;
import E_Commerce.e_commerce.User.Repouser;

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
}
