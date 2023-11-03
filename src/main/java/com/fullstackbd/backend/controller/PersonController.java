package com.fullstackbd.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackbd.backend.entity.Message;
import com.fullstackbd.backend.entity.Person;
import com.fullstackbd.backend.service.CrudService;

import lombok.Getter;

@Getter
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/people")
public class PersonController implements CrudController<Person, Long> {

  @Autowired
  private CrudService<Person, Long> service;

  @Override
  public List<Person> fetchAll() {
    return service.findAll();
  }

  @Override
  public ResponseEntity<?> fetchById(Long id) {
    Person person = service.findById(id);
    if (person != null) {
      return ResponseEntity.status(HttpStatus.OK).body(person);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      Message
        .builder()
        .message("Person Not Found")
        .result(false)
        .statusCode(HttpStatus.NOT_FOUND.value())
        .build()
    );
  }

  @Override
  public ResponseEntity<?> add(Person person) {
    Person savedPerson = service.save(person);
    if (savedPerson != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
      Message
        .builder()
        .message("Could not Save Person")
        .result(false)
        .statusCode(HttpStatus.NOT_FOUND.value())
        .build()
    );
  }

  @Override
  public ResponseEntity<?> update(Long id, Person person) {
    Person updatedPerson = service.save(id, person);
    if (updatedPerson != null) {
      return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
      Message
        .builder()
        .message("Could not save Person.")
        .result(false)
        .statusCode(HttpStatus.NOT_FOUND.value())
        .build()
    );
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    Person person = service.delete(id);
    if (person != null) {
      return ResponseEntity.status(HttpStatus.OK).body(person);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      Message
        .builder()
        .message("Person Not Foun")
        .result(false)
        .statusCode(HttpStatus.NOT_FOUND.value())
        .build()
    );
  }
  
}
