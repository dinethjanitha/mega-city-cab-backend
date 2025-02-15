package com.example.megacitycabbackend.repo;

import com.example.megacitycabbackend.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserModel , String> {

    UserModel findByUsername(String username);
}
