package kony.insta.repositories;
import java.util.*;
import kony.insta.entities.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class userRepository {

    private final TreeSet<userEntity> DB;
    @Autowired
    public userRepository(final TreeSet<userEntity>db)
    {
        this.DB=db;
    }
    public long addUser(userEntity user)
    {
        user.setId(DB.size()+1);
        this.DB.add(user);
        return this.DB.size();
    }
    public userEntity getUser(Long id)
    {

        return this.DB.stream().filter((i->i.getId()==id)).findFirst().orElse(null);
    }
}
