package com.example.restjwt.service;

import com.example.restjwt.entity.Income;
import com.example.restjwt.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;

    public Set<Income> getByIncome(Integer CardToId){
        Set<Income> set=new LinkedHashSet<>();
        for (Income income : incomeRepository.getAllByCardToId(CardToId)) {
            set.add(income);
        }
        return set;
    }
}
