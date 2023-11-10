package com.dxclogin.dxclogin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
public class TokenService {

    @Bean
    SecretKey secretKey() {
        String secretString = "RUY5S3gRUfiSqWWLt8nAbQKWD4FJzblRev6gfp2MCRYShV9wdFIMa4myQFGdeHvXRe1zvSZHMj1nGtoygH8tWINCwBJ1sU9jVJnr";
        byte[] secretBytes = secretString.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(secretBytes, "HmacSHA256");
    }
}
