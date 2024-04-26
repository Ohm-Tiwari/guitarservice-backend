package edu.iu.otiwari.guitarservice.repository;

import edu.iu.otiwari.guitarservice.model.GuitarData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository
        extends CrudRepository<GuitarData, Integer> {
}
