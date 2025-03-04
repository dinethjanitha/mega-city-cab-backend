package com.example.megacitycabbackend.repo;

import com.example.megacitycabbackend.dto.CabDto;
import com.example.megacitycabbackend.model.CabModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepo extends MongoRepository<CabModel , String> {

    Object findByStatus(String status);

    List<CabDto> findAllByStatus(String status);

    List<CabDto> findByDriveId(String driveId);

    List<CabDto> findByDriverLicence(String driverLicence);
}
