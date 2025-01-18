package org.practice.tacoproject.repository;

import org.practice.tacoproject.entity.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository  extends CrudRepository<Taco, Long> {
}
