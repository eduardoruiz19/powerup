package com.pragma.powerup.application.security;

import com.pragma.powerup.application.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private  RegisterUserDetailsService registerUserDetailsService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(registerUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate","/**/logout","/**/user").permitAll()
        // Habilitar pagina de Swagger http://localhost:8081/swagger-ui/index.html
        http.csrf().disable().authorizeRequests()
                .antMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**"
                        ,"/**/authenticate"
                        ,"/**/signup"
                        ,"/**/logout",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        //root pass: $2a$10$XJ1Cbj7z/k0Yq0pjLc8oP.s4MVeNNk6ivE8lJn4ZV07PgItl06nVa
        // 1234 pass:$2a$10$YjuDCgNZPA6kbdU3EONIKuWbHV2lCYFCIg0aG8gwKQ8pz2jH4Te/S
        System.out.println("pass:"+ new BCryptPasswordEncoder().encode("1234"));

    }

}
