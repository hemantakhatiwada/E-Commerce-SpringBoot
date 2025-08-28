package E_Commerce.e_commerce.Product;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Serviceecommerce {
    private Repositoryecommerce repo;

    public Serviceecommerce(Repositoryecommerce repo) {
        this.repo = repo;
    }

    public List<Modelecommerce> getallproduct() {
        return repo.findAll();
    }

    public Modelecommerce getproductbyid(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Modelecommerce saveproduct(Modelecommerce product) {
        return repo.save(product);
    }

    public void deleteproduct(Long id) {
       repo.deleteById(id);
    }
    }

