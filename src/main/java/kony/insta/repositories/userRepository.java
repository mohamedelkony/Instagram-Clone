package kony.insta.repositories;

import java.util.*;

import kony.insta.entities.userEntity;
import kony.insta.exceptions.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userRepository {
    private final Map<String,userEntity> DB;

    public userRepository() {
        this.DB = new TreeMap<>();
    }

    public int addUser(userEntity user) {
        if(DB.containsKey(user.getUsername()))
            throw new BadRequest("Username is already taken,please modify it");
        user.setId(DB.size() + 1);
        this.DB.put(user.getUsername(),user);
        return this.DB.size();
    }

    public userEntity getUser(String username) {
        return this.DB.getOrDefault(username,null);
    }
}
