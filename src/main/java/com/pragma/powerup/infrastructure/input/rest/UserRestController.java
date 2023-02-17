package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.handler.IObjectHandler;
import com.pragma.powerup.application.handler.IUserHandler;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;


    @Operation(summary = "Add a new User Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Owner created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User Owner already exists", content = @Content)
    })
    @PostMapping("/owner")
    public ResponseEntity<?> saveOwner(@RequestBody UserRequestDto userRequestDto) {
        System.out.println("llega a saveOwner");
        userRequestDto.setRol("ADMIN");
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


    @Operation(summary = "Add a new User Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Client created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User Client already exists", content = @Content)
    })
    @PostMapping("/client")
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
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
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

}