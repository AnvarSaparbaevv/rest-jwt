package com.example.restjwt.controller;

import com.example.restjwt.Result;
import com.example.restjwt.dto.TransferDto;
import com.example.restjwt.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moneyTransfer")
public class MoneyTransferController {
    @Autowired
    MoneyTransferService service;

    @PostMapping
    public ResponseEntity<Result> moneyTransfer(@RequestBody TransferDto dto){
        Result result = service.moneyTransfer(dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }
}
