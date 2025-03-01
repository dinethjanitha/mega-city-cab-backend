package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.dto.CabDto;
import com.example.megacitycabbackend.model.CabModel;
import com.example.megacitycabbackend.repo.CabRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Optional;

@Service
public class CabService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CabRepo cabRepo;

    public ResponseEntity<?> addCab(CabDto cabDto){

        try{
            CabModel cab = cabRepo.save(modelMapper.map(cabDto , CabModel.class));
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created!");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }




}
