package io.trucker.Repository;

import io.trucker.Entity.TruckData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends CrudRepository<TruckData, String> {
}
