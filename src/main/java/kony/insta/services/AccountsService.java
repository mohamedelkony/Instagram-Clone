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
    public AccountsService(userRepository repo) {
        this.repo = repo;
    }

    public registerDTOres registerUser(registerDTO user) {
        var entity = new userEntity();
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return new registerDTOres(this.repo.addUser(entity));
    }

    public getUserDTO getUser(String username) {
        userEntity x = this.repo.getUser(username);
        if (x == null)
            throw new NotFoundException("no user found");
        return getUserDTO.builder()
                .age(x.getAge())
                .email(x.getEmail())
                .username(x.getUsername())
                .gender(x.getGender())
                .id(x.getId())
                .build();
    }
}
