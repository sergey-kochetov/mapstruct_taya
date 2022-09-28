package com.example.mapstruct_taya.service.auth;

import com.example.mapstruct_taya.dto.product.ProductRequest;
import com.example.mapstruct_taya.validator.AuthenticationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableConfigurationProperties({AuthProperties.class})
public class AuthService {

    private final AuthProperties authProperties;

    public void auth(final ProductRequest request) {
        log.info("Attempting to authenticate for a request");


        //TODO уточнить: имя пользователя сравнивать с учетом регистра или без
        if (!Objects.equals(request.getUser(), authProperties.getUsername()) ||
                !Objects.equals(request.getPass(), authProperties.getPassword())) {
            throw new AuthenticationException(1002, "Incorrect user or pass");
        }
    }
}
