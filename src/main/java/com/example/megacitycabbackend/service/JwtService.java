package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.model.UserModel;
import com.example.megacitycabbackend.repo.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

//    public String extractUsername(){
//        return Jwts.parser()
//    }
//
    @Autowired
    public UserRepo userRepo;

    String newSecratKey = "c2VjcmV0LWtleS1mb3Itand0LXNpZ25pbmctMjU2LWJpdHM=";
    String secratKey = "";

    public JwtService(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGenerator.generateKey();
            secratKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SecretKey fixedSecretKey(){
        byte [] keyByte = Decoders.BASE64.decode(newSecratKey);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String generateToken(String username , String role , String id , String email){
        Map<String , Object> claims = new HashMap<>();
        claims.put("role" , role);
        claims.put("id", id );
        claims.put("email" , email);
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 60))
                .and()
                .signWith(fixedSecretKey())
                .compact();
    }

    public String extractUsername(String token){
        return Jwts
                .parser()
                .verifyWith(fixedSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


    public boolean validateToken(String token, String username) {
        UserModel user  = userRepo.findByUsername(username);


        if(user == null){
            System.out.println("user not found!");
            return false;
        }


        return isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {

        try{
            Claims claims = Jwts.parser()
                    .verifyWith(fixedSecretKey() )
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            System.out.println("Token Expiration: " + claims.getExpiration());
            System.out.println("Current Date: " + new Date());
            boolean value = claims.getExpiration().before(new Date());
            System.out.println("Is Token Expired: " + value);
            return value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public SecretKey getKey(){
        byte [] keyByte = Decoders.BASE64.decode(secratKey);
        System.out.println(Keys.hmacShaKeyFor(keyByte));
        return Keys.hmacShaKeyFor(keyByte);
    }


}
