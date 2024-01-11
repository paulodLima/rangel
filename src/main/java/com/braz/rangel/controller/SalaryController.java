package com.braz.rangel.controller;

import com.braz.rangel.dto.SalaryMonthDto;
import com.braz.rangel.entity.SalaryEntity;
import com.braz.rangel.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

    @Autowired
    private SalaryService service;

    @GetMapping
    public ResponseEntity<Stream<SalaryEntity>> getSalatyAll(){
        return service.getSalaryAll();
    }
    @GetMapping(value = "/salaryMonth")
    public List<SalaryMonthDto> getSalatyAllDTO(){
        return service.getSalaryAllList();
    }
}
