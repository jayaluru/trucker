package io.trucker.Controller;

import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;
import io.trucker.Service.TruckService;
import io.trucker.Service.TruckdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



//    @GetMapping("/{id}")
//    public Employee read(@PathVariable String id) {
//        return employeeService.findAll();
//    }

//    @GetMapping
//    public Employee read() {
//        return employeeService.findAll();
//    }
//
//    @PutMapping(path = "/employees", consumes = "application/json", produces = "application/json")
//    public String createEmployee(@RequestBody Employee emp) {
//        System.out.println(emp);
//        return employeeService.create(emp);
//        }

}
