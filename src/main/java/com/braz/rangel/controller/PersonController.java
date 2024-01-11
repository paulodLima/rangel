package com.braz.rangel.controller;

import com.braz.rangel.entity.PersonEntity;
import com.braz.rangel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    private ResponseEntity<List<PersonEntity>> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(value = "/last")
    private ResponseEntity<PersonEntity> getPersonLast(){
        return personService.getLastPerson();
    }

    @GetMapping(value = "/first")
    private ResponseEntity<PersonEntity> getPersonFirst(){
        return personService.getFirstPerson();
    }

    @PutMapping
    private ResponseEntity<PersonEntity> updatePerson(@RequestBody PersonEntity entity){
        return personService.updatePerson(entity);
    }

}
