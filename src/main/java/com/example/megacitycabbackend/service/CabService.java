package com.example.megacitycabbackend.service;


import com.example.megacitycabbackend.dto.CabDto;
import com.example.megacitycabbackend.model.CabModel;
import com.example.megacitycabbackend.repo.CabRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CabService {



    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CabRepo cabRepo;

    private static String UPLOAD_DIR = "uploads/";

    public ResponseEntity<?> addCab(CabDto cabDto , MultipartFile image){

        List<CabDto> checkdriver = cabRepo.findByDriverLicence(cabDto.getDriverLicence());

        if(!checkdriver.isEmpty()){
            System.out.println("Driver already have cab");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This driving licence already regisred with vehical remove that vehical to add new vehical");
        }

        try{
            if(!image.isEmpty()){
                String imageUrl = saveImage(image);
                cabDto.setImgUrl(imageUrl);
            }else{
                cabDto.setImgUrl(null);
            }

            cabDto.setAddedDate(new Date().toString());
            CabModel cab = cabRepo.save(modelMapper.map(cabDto , CabModel.class));
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created!");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }


    private String saveImage(MultipartFile image)
        throws IOException {
        if(image.isEmpty()){
            throw new IOException("Image not find");
        }
        Random rand = new Random();
        int randnumber = rand.nextInt(1000000);
        String filename = image.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + randnumber + filename);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, image.getBytes());

        return filePath.toString();
    }


//    public ResponseEntity<?> getAllCabs(){
//        return ResponseEntity.status(HttpStatus.OK).body(cabRepo.findAll());
//    }

    public ResponseEntity<?> getAvalibleCabs(){

        List<CabDto> cabDtoList = cabRepo.findAllByStatus("available").stream().collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(cabDtoList);
    }


    public ResponseEntity<?> getCab(String id){

        Optional<CabModel> cab = cabRepo.findById(id);

        if(cab.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(cab.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cab Not found!");


    }


}
