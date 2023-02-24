package com.pragma.powerup.infrastructure.feignClient;

import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value="feingDemo",
        url = "http://localhost:8082/api/v1/object",   //directorio que va a consultar el feign
        configuration = FeignClientConfig.class)

@Headers("x-requester-id: {requester}")
public interface FeingServiceUtil {
    @GetMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    //lo que se espera recibir
    List<ObjectResponseDto> getObjects(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping(
            path = "/pruebaheader",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    String getHeader(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

}
