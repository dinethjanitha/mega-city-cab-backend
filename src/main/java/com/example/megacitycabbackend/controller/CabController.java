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
                                     @RequestParam("image") MultipartFile image){

        CabDto cabDto = new CabDto();
        cabDto.setCabName(name);
        cabDto.setCabDescription(description);

        return cabService.addCab(cabDto , image);

    }
}
