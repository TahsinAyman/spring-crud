package com.fullstackbd.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fullstackbd.backend.service.CrudService;


public interface CrudController<E, I> {

  CrudService<E, I> getService();

  @GetMapping("/")
  List<E> fetchAll();

  @GetMapping("/{id}")
  ResponseEntity<?> fetchById(@PathVariable("id") I id);

  @PostMapping("/")
  ResponseEntity<?> add(@RequestBody E person);

  @PutMapping("/{id}")
  ResponseEntity<?> update(@PathVariable("id") I id, @RequestBody E person);

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable("id") I id);
}