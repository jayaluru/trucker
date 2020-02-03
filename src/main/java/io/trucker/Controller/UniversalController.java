package io.trucker.Controller;

import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;
import io.trucker.Service.TruckService;
import io.trucker.Service.TruckdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin( origins = "http://mocker.ennate.academy")
public class UniversalController {

    @Autowired
    TruckdataService truckdataService;
    @Autowired
    TruckService truckService;



    @PostMapping(path = "/readings", consumes = "application/json", produces = "application/json")
    public TruckData createTruckData(@RequestBody TruckData truckData) {
        System.out.println(truckData);
        if(truckData == null){
            System.out.println("truck data is null");}
        return truckdataService.createTruckData(truckData);
    }

    @PutMapping(path = "/vehicles", consumes = "application/json", produces = "application/json")
    public String createTruck(@RequestBody List<Truck> truck) {
        System.out.println(truck);
        for(Truck trk: truck){
            truckService.createUpdateTruck(trk);
            }
        return "all set";
        }

    @PutMapping(path = "/getTrucksFromData", produces = "application/json")
    public List<TruckData> getTruck() {
        Iterable<TruckData> var = truckdataService.findAll();
        List<TruckData> output = new ArrayList<>();
        for(TruckData td: var){
            output.add(td);
        }
        return output;
    }


//    @PutMapping(path = "/employees", consumes = "application/json", produces = "application/json")
//    public String createEmployee(@RequestBody Employee emp) {
//        System.out.println(emp);
//        return employeeService.create(emp);
//        }

}
