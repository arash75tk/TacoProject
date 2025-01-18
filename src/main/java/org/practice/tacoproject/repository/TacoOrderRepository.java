package org.practice.tacoproject.repository;

import org.practice.tacoproject.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface TacoOrderRepository extends CrudRepository<TacoOrder, Long> {
}
