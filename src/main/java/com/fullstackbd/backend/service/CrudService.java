package com.fullstackbd.backend.service;

import java.util.List;

/**
 * Business Logic structure
 */


public interface CrudService<E, I> {

  List<E> findAll();
  E findById(I id);
  E save(E e);
  E save(I i, E e);
  E delete(I i);
}
