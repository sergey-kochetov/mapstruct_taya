package com.example.mapstruct_taya.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@AllArgsConstructor
public class LoginService {
    private final RestTemplate restTemplate;

    private static String URL_LOGIN = "https://app.edocgen.com/login";
    private static String BODY_LOGIN = "{\"username\": \"USER\", \"password\": \"PASS\"}";


}
