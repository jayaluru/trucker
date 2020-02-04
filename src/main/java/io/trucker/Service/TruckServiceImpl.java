package io.trucker.Service;

import io.trucker.Entity.Truck;
import io.trucker.Repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    TruckRepository truckRepository;

    @Override
    public Truck createUpdateTruck(Truck truck) {
        if(truckRepository.existsById(truck.getVin())){
            truckRepository.deleteById(truck.getVin());
        }
        return truckRepository.save(truck);
    }

    @Override
    public List<Truck> allFilters(String vin_id, String make, int redline_rpm, int year){
        return truckRepository.allFilters(vin_id, make, redline_rpm, year);
    }

    @Override
    public List<Truck> allFiltersYear(int year){
        return truckRepository.allFiltersYear(year);
    }

    @Override
    public List<Truck> allFiltersVinMake(String vin_id, String make){
        return truckRepository.allFiltersVinMake(vin_id, make);
    }

}
