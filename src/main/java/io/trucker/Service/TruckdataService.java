package io.trucker.Service;

import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;

public interface TruckdataService {
    TruckData createTruckData(TruckData truckData);
    Iterable<TruckData> findAll();
}

