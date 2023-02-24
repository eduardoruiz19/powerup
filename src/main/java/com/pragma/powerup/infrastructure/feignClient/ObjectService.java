package com.pragma.powerup.infrastructure.feignClient;

import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectService {

    private final  JWTUtil jwtUtil;
    private  final FeingServiceUtil client;
    public List<ObjectResponseDto> getUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        String token=authorization.substring(7);
        String username=jwtUtil.extractUsername(token);

        return (List<ObjectResponseDto>) new ResponseEntity<>(client.getObjects(authorization), HttpStatus.OK);
    }

    public  String getUser(String authorization) { return "ok"; }
    public  String   getHeader(String authorization) { return authorization; }
}
