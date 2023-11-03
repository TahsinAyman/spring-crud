package com.fullstackbd.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstackbd.backend.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
