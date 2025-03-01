package com.example.megacitycabbackend.repo;

import com.example.megacitycabbackend.model.CabModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepo extends MongoRepository<CabModel , String> {

}
