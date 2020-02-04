package io.trucker.Service;

import io.trucker.Entity.Truck;
import java.util.List;

public interface TruckService {
    Truck createUpdateTruck(Truck truck);
    List<Truck> allFilters(String vin_id, String make, String redline_rpm, int year);
}
