package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.handler.IRolHandler;
import com.pragma.powerup.application.handler.IRolHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rol")
@RequiredArgsConstructor
public class RolRestController {

    private final IRolHandler rolHandler;

    @Operation(summary = "Add a new Rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rol created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Rol already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRol(@RequestBody RolRequestDto rolRequestDto) {
        rolHandler.saveObject(rolRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Rols")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Rols returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RolResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RolResponseDto>> getAllRols() {
        return ResponseEntity.ok(rolHandler.getAllObjects());
    }

}