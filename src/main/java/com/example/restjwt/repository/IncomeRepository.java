package com.example.restjwt.repository;

import com.example.restjwt.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path = "income")
public interface IncomeRepository extends JpaRepository<Income,Integer> {

    Set<Income> getAllByCardToId(Integer cardTo_id);
}
