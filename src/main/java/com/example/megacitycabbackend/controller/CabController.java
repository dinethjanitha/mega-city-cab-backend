package com.example.megacitycabbackend.controller;

import com.example.megacitycabbackend.dto.CabDto;
import com.example.megacitycabbackend.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/")
public class CabController {

    @Autowired
    private CabService cabService;

    @PostMapping("/cabs")
    public ResponseEntity<?> addCabs(@RequestParam("cabName") String name,
                                     @RequestParam("description") String description,
                                     @RequestParam("driverid") String driverid,
                                     @RequestParam("driverlicence") String driverlicence,
                                     @RequestParam("status") String status,
                                     @RequestParam("cabOwnerName") String cabOwnerName,
                                     @RequestParam("phoneNumber") String phoneNumber,
                                     @RequestParam("sheetCount") int sheetCount,
                                     @RequestParam("first7kmPrice") double first7kmPrice,
                                     @RequestParam("avarageKmPrice") double avarageKmPrice,
                                     @RequestParam("image") MultipartFile image){

        CabDto cabDto = new CabDto();
        cabDto.setCabName(name);
        cabDto.setDriverLicence(driverlicence);
        cabDto.setDriveId(driverid);
        cabDto.setStatus(status);
        cabDto.setOwnerName(cabOwnerName);
        cabDto.setPhoneNumber(phoneNumber);
        cabDto.setFirst7kmPrice(first7kmPrice);
        cabDto.setAvarageKmPrice(avarageKmPrice);
        cabDto.setCabDescription(description);
        cabDto.setSheetCount(sheetCount);

        if(image.isEmpty()){
            image = null;
        }
        return cabService.addCab(cabDto , image);

    }

    @GetMapping("/cabs")
    public ResponseEntity<?> getCabs(){
        return cabService.getAvalibleCabs();
    }

    @GetMapping("/cab/{id}")
    public ResponseEntity<?> getCab(@PathVariable String id){
        return cabService.getCab(id);
    }


}
