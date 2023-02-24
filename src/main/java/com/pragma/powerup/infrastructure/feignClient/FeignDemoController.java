package com.pragma.powerup.infrastructure.feignClient;

import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class FeignDemoController {
    @Autowired
    private  FeingServiceUtil feingServiceUtil;

    @Autowired
    private JWTUtil jwtUtil;
    @GetMapping("/username")
    public ResponseEntity<List<ObjectResponseDto>> getAllRols(@RequestHeader("authorization") String authorization) {

        System.out.println("enviando  al otro Servicio:"+authorization);
        String token=authorization.substring(7);
        String username=jwtUtil.extractUsername(token);
        System.out.println("username decodificado:"+username);

        return new ResponseEntity<>(feingServiceUtil.getObjects(authorization), HttpStatus.OK);


    }

    @GetMapping("/pruebaheader")
    public ResponseEntity<?> getHeader(@RequestHeader("authorization") String authorization){
        //System.out.println("RequestBody:"+requestBody);
        System.out.println("Authorization enviada:"+authorization);
        return new ResponseEntity<>(feingServiceUtil.getHeader(authorization),HttpStatus.OK);
        //return "llega al otro Servicio:"+authorization;


    }

}
