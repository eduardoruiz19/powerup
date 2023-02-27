package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.handler.IObjectHandler;
import com.pragma.powerup.application.handler.IUserHandler;

import com.pragma.powerup.application.security.JWTUtil;
import com.pragma.powerup.infrastructure.feignClient.BearerHeader;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;
    private final JWTUtil jwtUtil;

    @Operation(summary = "Add a new User Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Owner created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User Owner already exists", content = @Content)
    })
    @PostMapping("/owner")
    public ResponseEntity<?> saveOwner(@Valid @RequestBody UserRequestDto userRequestDto, @RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) throws ConstraintViolationException {
        System.out.println("llega a saveOwner");
        userRequestDto.setRol("OWNER");
        //Ojo Eduardo aquí recibe el Token que viene del otro Microservicio


            UserResponseDto userDto = getDetailsAuthenticatedUser(bearerHeader.toString());
            if(userDto.getRol().equals("ADMIN")){
                userHandler.saveUser(userRequestDto);
            }else {
                Map<String,Object > response = new HashMap<>();
                response.put("mensaje","Data Insertion Error");
                response.put("error","Permission Denied");

                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
            }


        return new ResponseEntity<UserRequestDto>(HttpStatus.CREATED);
    }


    @Operation(summary = "Add a new User Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Client created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User Client already exists", content = @Content)
        })
    @PostMapping("/signup")
    public ResponseEntity<?> saveClient(@RequestBody UserRequestDto userRequestDto) {
        //System.out.println("llega a saveOwner");
        userRequestDto.setRol("CLIENT");
        Map<String,Object > response = new HashMap<>();
        try{
            userHandler.saveUser(userRequestDto);
        }catch (DataAccessException e){
            response.put("mensaje","Data Insertion Error");
            response.put("error",e.getMessage());
            //response.put("error",e.getMostSpecificCause());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<UserRequestDto>(HttpStatus.CREATED);
    }


    @Operation(summary = "Add a new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto, @RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {
        System.out.println("llega a saveUser");
        Map<String,Object > response = new HashMap<>();
        try{



            userHandler.saveUser(userRequestDto);
        }catch (DataAccessException e){
            response.put("mensaje","Data Insertion Error");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserRequestDto>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Users returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAllObjects() {
        return ResponseEntity.ok(userHandler.getAllUsers());
    }


    @GetMapping("/list" )
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {
        System.out.println("llega a list users");
        //Ojo Eduardo aquí recibe el Token que viene del otro Microservicio
        System.out.println("Authorization enviada desde el otro servicio:"+bearerHeader.toString());
        String token=bearerHeader.toString().substring(7);
        System.out.println("Token:'"+token+"'");
        try{
            String username=jwtUtil.extractUsername(token);
            System.out.println("usuario:"+username);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(userHandler.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/getuser1")
    public ResponseEntity<UserResponseDto> getRoleUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {
        System.out.println("llega a list users");
        //Ojo Eduardo aquí recibe el Token que viene del otro Microservicio
        System.out.println("Authorization enviada desde el otro servicio:"+bearerHeader.toString());
        String token=bearerHeader.toString().substring(7);
        System.out.println("Token:'"+token+"'");
        String username = null;
        try{
            username=jwtUtil.extractUsername(token);
            System.out.println("usuario:"+username);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(userHandler.getUserByEmail(username),HttpStatus.OK);
    }

    @GetMapping("/getuserdata")
    public ResponseEntity<UserResponseDto> getUserData(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {
        System.out.println("llega a list users");
        //Ojo Eduardo aquí recibe el Token que viene del otro Microservicio
        System.out.println("Authorization enviada desde el otro servicio:"+bearerHeader.toString());
        String token=bearerHeader.toString().substring(7);
        System.out.println("Token:'"+token+"'");
        String username = null;
        try{
            username=jwtUtil.extractUsername(token);
            System.out.println("usuario:"+username);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(userHandler.getUserByEmail(username),HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") long id){
        System.out.println("Consulta por Id");
        UserResponseDto usuario = userHandler.getUserById(id);
        System.out.println("Usuario:"+usuario.getApellido());
        return new ResponseEntity<UserResponseDto>(usuario, HttpStatus.OK);
    }

    UserResponseDto getDetailsAuthenticatedUser(String token){
        System.out.println("Authorization enviada desde el otro servicio:"+token);
        token=token.substring(7);
        System.out.println("Token:'"+token+"'");
        String username = null;

        username=jwtUtil.extractUsername(token);
        System.out.println("usuario:"+username);
        UserResponseDto userDto = userHandler.getUserByEmail(username);
        return  userDto;

    }
}