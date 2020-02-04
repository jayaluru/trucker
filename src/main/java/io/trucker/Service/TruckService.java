package io.trucker.Service;

import io.trucker.Entity.Truck;
import java.util.List;

public interface TruckService {
    Truck createUpdateTruck(Truck truck);
    List<Truck> allFilters(String vin_id, String make, int redline_rpm, int year);
    List<Truck> allFiltersYear(int year);
    List<Truck> allFiltersVinMake(String vin_id, String make);
}
