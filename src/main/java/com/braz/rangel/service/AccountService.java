package com.braz.rangel.service;

import com.braz.rangel.entity.AccountEntity;
import com.braz.rangel.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<AccountEntity>> getAccountAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
