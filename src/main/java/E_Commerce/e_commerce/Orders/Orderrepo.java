package E_Commerce.e_commerce.Orders;

import E_Commerce.e_commerce.User.Modeluser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Orderrepo  extends JpaRepository<Ordermodel, Long> {

        List<Ordermodel> findByUser(Modeluser user);

    }


