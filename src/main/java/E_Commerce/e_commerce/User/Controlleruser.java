package E_Commerce.e_commerce.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class Controlleruser {
  private Serviceuser serv;
  public Controlleruser(Serviceuser serv)
  {
     this.serv=serv;
  }
  @GetMapping("/getuser")
    public List<Modeluser>getalluser()
  {
      return serv.getalluser();
  }
  @PostMapping("/register")
    public  Modeluser register( @RequestBody Modeluser user)
  {
      return serv.register(user);
  }
  @GetMapping("/findbyid/{id}")
    public Modeluser getuserbyid(@PathVariable  Long id)
  {
      return serv.getuserbyid(id);
  }
}
