package io.trucker.Service;

import io.trucker.Entity.Tires;
import io.trucker.Repository.TiresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiresServiceImpl implements TiresService {

    @Autowired
    TiresRepository tiresRepository;
    @Override
    public Tires create(Tires tires) {
        return tiresRepository.save(tires);
//        return null;
    }
}
