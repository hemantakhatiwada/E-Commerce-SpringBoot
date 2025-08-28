package E_Commerce.e_commerce.CartItem;
import java.util.List;

import E_Commerce.e_commerce.User.Modeluser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repocartitem extends JpaRepository<Modelcartitem,Long> {
    List<Modelcartitem> findByModeluser(Modeluser modeluser);
}
