package com.braz.rangel.service;

import com.braz.rangel.entity.PersonEntity;
import com.braz.rangel.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<PersonEntity>> getAllPerson(){
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<PersonEntity> getLastPerson(){
        return new ResponseEntity<>(repository.findAll().getLast(),HttpStatus.OK);
    }
    public ResponseEntity<PersonEntity> getFirstPerson(){
        return new ResponseEntity<>(repository.findAll().getFirst(),HttpStatus.OK);
    }

    public ResponseEntity<PersonEntity> updatePerson(PersonEntity entity) {
         Optional<PersonEntity> person = repository.findById(entity.getId());

         if(person.isPresent()){
             PersonEntity personEntity = person.get();
             personEntity.setBirthDate(entity.getBirthDate());
             personEntity.setName(entity.getName());
             personEntity.setJobTitle(entity.getJobTitle());

             repository.save(personEntity);
             return new ResponseEntity<>(personEntity, HttpStatus.OK);
         }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<PersonEntity> savePerson(PersonEntity entity){
        repository.save(entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
