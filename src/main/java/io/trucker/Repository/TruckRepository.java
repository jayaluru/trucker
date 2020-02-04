package io.trucker.Repository;

import io.trucker.Entity.Truck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends CrudRepository<Truck, String> {

    //t.vin = ?1 and t.make = ?2 and t.redline_rpm = ?3 and
    //String vin_id, String make, int redline_rpm,
    @Query("SELECT t FROM Truck t WHERE t.vin = ?1 and t.make = ?2 and t.redlineRpm = ?3 and t.year = ?4")
    List<Truck> allFilters(String vin_id, String make, int redline_rpm, int year);

    @Query("SELECT t FROM Truck t WHERE t.year = ?1")
    List<Truck> allFiltersYear(int year);

    @Query("SELECT t FROM Truck t WHERE t.vin = ?1 and t.make = ?2")
    List<Truck> allFiltersVinMake(String vin_id, String make);
}
