package E_Commerce.e_commerce.User;

import org.springframework.stereotype.Service;
import E_Commerce.e_commerce.User.Repouser;

import java.util.List;

@Service
public class Serviceuser {
    private Repouser repouser;
    public Serviceuser(Repouser repouser)
    {
        this.repouser=repouser;

    }
    public List<Modeluser>getalluser()
    {
      return   repouser.findAll();
    }
    public Modeluser getuserbyid(Long id)
    {
        return repouser.findById(id).orElse(null);
    }
    public Modeluser register(Modeluser user)
    {
        return repouser.save(user);
    }

}
