package com.fullstackbd.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackbd.backend.entity.Person;
import com.fullstackbd.backend.repository.PersonRepository;

@Service
public class PersonService implements CrudService<Person, Long> {

  @Autowired
  private PersonRepository repository;

  @Override
  public List<Person> findAll() {
    return repository.findAll();
  }

  @Override
  public Person findById(Long id) {
    Person person = repository.findById(id).orElse(null);
    return person;
  }

  @Override
  public Person save(Person e) {
    try {
      Person person = repository.save(e);
      return person;
    } catch (Exception e1) {
      return null;
    }
  }

  @Override
  public Person save(Long i, Person e) {
    Person oldPerson = this.findById(i);
    if (oldPerson != null) {
      oldPerson.setName(e.getName());
      oldPerson.setAge(e.getAge());
      return repository.save(oldPerson); // updated
    }
    return null;

  }

  @Override
  public Person delete(Long i) {
    Person person = this.findById(i);
    if (person != null) {
      repository.deleteById(i);
      return person;
    }
    return null;
  }
  
}
