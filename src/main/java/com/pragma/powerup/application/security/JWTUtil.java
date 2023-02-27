package com.pragma.powerup.application.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    private static final  String KEY="ABC_123";
    public String generateToken(UserDetails userDetails, String password){
        Map<String,Object> cl = new HashMap<>();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256,KEY)
                .compact();
    }


    public boolean validateToken(String token, UserDetails userDetails ){
        return  userDetails.getUsername().equals(extractUsername(token))  && !isTokenExpired(token);
    }

    private Claims getClaims(String token){
        return  Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    /**
     *  Verify if Token is Expired
     * @param token  = token to Verify
     * @return True is Expired - False is not Expired
     */
    public boolean isTokenExpired(String token){
        return  getClaims(token).getExpiration().before(new Date());
    }
    public  String extractUsername(String token){
        return  getClaims(token).getSubject();  //Extraer el Usuario de la peticion
    }
}
