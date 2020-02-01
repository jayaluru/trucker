package io.trucker.Controller;

import io.trucker.Entity.TruckData;
import io.trucker.Service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( origins = "http://mocker.ennate.academy")
public class UniversalController {

    @Autowired
    TruckService truckService;


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


    @PostMapping(path = "/readings", consumes = "application/json", produces = "application/json")
    public TruckData createTruck(@RequestBody TruckData truckData) {
        System.out.println(truckData);
        if(truckData == null){
            System.out.println("truck is null");}
        return truckService.create(truckData);
    }
}
