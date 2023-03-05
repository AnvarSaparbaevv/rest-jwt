package com.example.restjwt.controller;

import com.example.restjwt.entity.Income;
import com.example.restjwt.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    IncomeService service;

    @GetMapping("/{toCardId}")
    public ResponseEntity<Set<Income>> getIncome(@PathVariable Integer toCardId){
        Set<Income> byIncome = service.getByIncome(toCardId);
        return ResponseEntity.status(HttpStatus.CREATED).body(byIncome);
    }
}
