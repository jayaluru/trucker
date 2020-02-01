package io.trucker.Service;

import io.trucker.Entity.TruckData;
import io.trucker.Exception.BadRequestException;
import io.trucker.Repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TruckServiceImpl implements TruckService{

    @Autowired
    TruckRepository truckRepository;

    @Transactional
    public TruckData create(TruckData truckData) {
        if(truckData == null){
            throw new BadRequestException("input object is Null");
        }
        System.out.println(truckData);
        return truckRepository.save(truckData);
    }
}
