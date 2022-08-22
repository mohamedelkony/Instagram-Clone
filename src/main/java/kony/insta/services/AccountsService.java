package kony.insta.services;

import kony.insta.dto.account.*;
import kony.insta.entities.userEntity;
import kony.insta.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kony.insta.exceptions.*;

@Service
public class AccountsService {
    private final userRepository userRepo;

    public AccountsService(userRepository repo) {
        userRepo= repo;
    }

    public registerDTOres registerUser(registerDTO user) {
        if(userRepo.findByUsername(user.getUsername())!=null)
            throw new BadRequest("Username already taken");
        userEntity entity = userEntity.builder()
        .age(user.getAge())
        .email(user.getEmail())
        .gender(user.getGender())
        .username(user.getUsername())
        .password(user.getPassword()).build();
        return new registerDTOres(userRepo.save(entity).getId());
    }

    public getUserDTO getUser(String username) {
       // int x=Authentication.getPrincipal().getId();
        userEntity x = userRepo.findByUsername(username);
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
