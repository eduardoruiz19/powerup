package com.pragma.powerup.infrastructure.feignClient;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    //private static final String AUTHENTICATION_HEADER = "my-security-header";
    private static final String AUTHENTICATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("pasa por apply interceptor");
        System.out.println(template.headers());
        propagateAuthorizationHeader(template);
    }

    private void propagateAuthorizationHeader(RequestTemplate template) {
        System.out.println("pasa por propagateAuthorizationHeader");
        System.out.println(template.headers());
        if (template.headers().containsKey(AUTHENTICATION_HEADER)) {
            System.out.println("the authorization {"+ AUTHENTICATION_HEADER+"} token has been already set");

        } else {
            log.trace("setting the authorization token {}", AUTHENTICATION_HEADER);
            System.out.println("setting the authorization token "+ AUTHENTICATION_HEADER);
            template.header(AUTHENTICATION_HEADER, SecurityContextHolder.getContext().getAuthentication().getName());
        }
    }}
