package kony.insta.repositories;

import java.util.*;

import kony.insta.entities.userEntity;
import kony.insta.exceptions.BadRequest;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface userRepository extends CrudRepository<userEntity,Long>{
    userEntity findByUsername(String username);
    @Transactional
    Long deleteByUsernameOrEmail(String username,String email);
}