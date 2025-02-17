package com.example.megacitycabbackend.repo;

import com.example.megacitycabbackend.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserModel , String> {

    UserModel findByUsername(String username);

    Optional<UserModel> findUserByEmail(String email);

    Optional<UserModel> findUserByNic(String nic);
}
