package kony.insta.services;
import kony.insta.dto.account.*;
import kony.insta.repositories.userRepository;
import kony.insta.entities.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kony.insta.exceptions.*;
@Service
public class AccountsService {


    private final userRepository repo;
    @Autowired
    public AccountsService(userRepository repo)
    {
        this.repo =repo;
    }
    public Long registerUser(registerDTO user)
    {
        var entity=new userEntity();
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return this.repo.addUser(entity);
    }
    public getUserDTO getUser(long id) {
        var x= this.repo.getUser(id);
        if(x==null)
            throw new NotFoundException("nod user found");
        var dto=new getUserDTO();
        dto.age=x.getAge();
        dto.email=x.getEmail();
        dto.gender=x.getGender();
        dto.username=x.getUsername();
        dto.id=x.getId();
        return dto;
    }
}
