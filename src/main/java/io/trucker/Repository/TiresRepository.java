package io.trucker.Repository;

import io.trucker.Entity.Tires;
import org.springframework.data.repository.CrudRepository;

public interface TiresRepository extends CrudRepository<Tires, String> {
}
