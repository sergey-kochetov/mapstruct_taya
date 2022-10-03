package com.example.mapstruct_taya.controller;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
@AllArgsConstructor
@Transactional(propagation = Propagation.NEVER)
public class DocumentController {
}
