package edu.iu.otiwari.guitarservice.repository;

import edu.iu.otiwari.guitarservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository
        extends CrudRepository<Order, Integer> {
}
