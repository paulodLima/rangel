package com.braz.rangel.service;

import com.braz.rangel.dto.SalaryMonthDto;
import com.braz.rangel.entity.SalaryEntity;
import com.braz.rangel.repository.SalaryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SalaryService {

    private final SalaryRepository repository;

    public SalaryService(SalaryRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Stream<SalaryEntity>> getSalaryAll (){
        return new ResponseEntity<>(repository.findAll().stream().sorted(Comparator.comparing(SalaryEntity::getPaymentDate)),HttpStatus.OK);
    }

    public List<SalaryMonthDto> getSalaryAllList (){
        return toEntity(repository.findAll());
        //return new ResponseEntity<>(repository.findAll().stream().sorted(Comparator.comparing(SalaryEntity::getPaymentDate)),HttpStatus.OK);
    }

    private List<SalaryMonthDto> toEntity(List<SalaryEntity> all) {
        List<SalaryMonthDto> salaryMonthDtos = new ArrayList<>();
        all.forEach(a -> {
            SalaryMonthDto dto = new SalaryMonthDto();

            dto.setName(a.getPersonEntity().getName());
            dto.setAccount(a.getPersonEntity().getAccountEntity().getAccount());
            dto.setDigit(a.getPersonEntity().getAccountEntity().getDigit());
            dto.setBank(a.getPersonEntity().getAccountEntity().getBank());
            dto.setSalary(a.getSalary());
            dto.setMonthYear(a.getMonthYear());
            dto.setDocument(a.getPersonEntity().getAccountEntity().getDocument());
            dto.setPaymentDate(a.getPaymentDate());

            salaryMonthDtos.add(dto);
        });

        return salaryMonthDtos;
    }


}
