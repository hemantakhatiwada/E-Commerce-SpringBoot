package E_Commerce.e_commerce.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controlleecommerce {
private Serviceecommerce service;
public Controlleecommerce(Serviceecommerce service)
{
    this.service=service;
}
@GetMapping("/getallproduct")
    public List<Modelecommerce> getallproduct()
    {
        return service.getallproduct();
    }

    @GetMapping("/getproductbyid/{id}")
    public Modelecommerce getproductbyid(@PathVariable Long id)
    {
        return service.getproductbyid(id);
    }

    @PostMapping("/saveproduct")
    public Modelecommerce saveproduct(@RequestBody Modelecommerce product)
    {
        return service.saveproduct(product);
    }
@DeleteMapping("/delete/{id}")
    public String  deleteproduct(@PathVariable Long id)
{
    service.deleteproduct(id);
    return "Id deleted"  + id;
}

}
