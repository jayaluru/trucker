package io.trucker.Service;

import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;
import io.trucker.Exception.BadRequestException;
import io.trucker.Repository.TruckdataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TruckdataServiceImpl implements TruckdataService {

    @Autowired
    TruckdataRepository truckdataRepository;

    @Transactional
    public TruckData createTruckData(TruckData truckData) {
        if(truckData == null){
            throw new BadRequestException("input object is Null");
        }
        //System.out.println(truckData);
        return truckdataRepository.save(truckData);
    }

    @Transactional
    public Iterable<TruckData> findAll(){
        return truckdataRepository.findAll();
    }
}
