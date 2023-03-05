package com.example.restjwt.service;

import com.example.restjwt.Result;
import com.example.restjwt.dto.TransferDto;
import com.example.restjwt.entity.Card;
import com.example.restjwt.entity.Income;
import com.example.restjwt.entity.Outcome;
import com.example.restjwt.repository.CardRepository;
import com.example.restjwt.repository.IncomeRepository;
import com.example.restjwt.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class MoneyTransferService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    public Result moneyTransfer(TransferDto dto){
        if (!cardRepository.existsCardByCardNumber(dto.getFromCard())){
            return new com.example.restjwt.Result("From Card not found!",false, HttpStatus.NOT_FOUND);
        }
        Card fromCard = cardRepository.getCardByCardNumber(dto.getFromCard());
        if (!cardRepository.existsCardByCardNumber(dto.getToCard())){
            return new Result("To Card not found!",false, HttpStatus.NOT_FOUND);
        }
        Card toCard = cardRepository.getCardByCardNumber(dto.getToCard());
        double summa=dto.getAmount();
        if (fromCard.getBalance()<(summa*1.01)){
            return new Result("There are not enough funds in this card!",false,HttpStatus.CONFLICT);
        }
        double a=fromCard.getBalance()-summa*1.01;
        fromCard.setBalance(a);
        cardRepository.save(fromCard);
        double s=toCard.getBalance()+summa;
        toCard.setBalance(s);
        cardRepository.save(toCard);
        Income income=new Income(null,fromCard,toCard,summa, LocalDateTime.now());
        incomeRepository.save(income);
        Outcome outcome=new Outcome(null,fromCard,toCard,summa,LocalDateTime.now(),summa*0.01);
        outcomeRepository.save(outcome);
        return new Result("Succesfill",true,HttpStatus.ACCEPTED);
    }
}
