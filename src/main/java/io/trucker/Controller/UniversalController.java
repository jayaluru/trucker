package io.trucker.Controller;

import com.google.gson.Gson;
import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;
import io.trucker.Service.AlertService;
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
    @Autowired
    AlertService alertService;


    @GetMapping("/getTest")
    public String getTest() {
        System.out.println("testTrucker controller called") ;
        return new String("getTest info");
    }


    @PostMapping(path = "/readings", consumes = "application/json", produces = "application/json")
    public String createTruckData(@RequestBody TruckData truckData) {
        //System.out.println(truckData);
        if(truckData == null){
            System.out.println("truck data is null");}
        truckData = truckdataService.createTruckData(truckData);
        //System.out.println(truckData.g);
        try{
            alertService.createAlert(truckData);
        }catch (NullPointerException e){
            System.out.println("alert start null exception");
        }

        return "all set";
    }

    @PutMapping(path = "/vehicles", consumes = "application/json", produces = "application/json")
    public String createTruck(@RequestBody List<Truck> truck) {
        //System.out.println(truck);
        for(Truck trk: truck){
            truckService.createUpdateTruck(trk);
            }
        return "all set";
        }

    @PutMapping(path = "/getAllTruckData", produces = "application/json")
    public String getTruck() {
        Iterable<TruckData> var = truckdataService.findAll();
        List<TruckData> output = new ArrayList<>();
        for(TruckData td: var){
            output.add(td);
        }

        String out = new Gson().toJson(output);
        return out;
    }

    @GetMapping("/getAllTruck")
    public String getAllTruck(@RequestParam(defaultValue = "%") String vin,
                          @RequestParam(defaultValue = "%") String make,
                          @RequestParam(defaultValue = "%") int redline_rpm,
                          @RequestParam(defaultValue = "2011") int year) {
        System.out.println("ID: " + vin + "make: " + make + "redline rpm: " + redline_rpm + "year: " + year) ;
        List<Truck> trucks = truckService.allFilters(vin, make, redline_rpm, year);
        return new Gson().toJson(trucks);
    }

    @GetMapping("/getAllTruckYear")
    public String getAllTruckYear(@RequestParam(defaultValue = "2011") int year) {
        System.out.println("year " + year) ;
        List<Truck> trucks = truckService.allFiltersYear(year);
        return new Gson().toJson(trucks);
    }

    @GetMapping("/getAllTruckVinMake")
    public String getAllTruckYear(@RequestParam(defaultValue = "%") String vin,
                                  @RequestParam(defaultValue = "%") String make) {
        System.out.println("ID: " + vin + "make: " + make ) ;
        List<Truck> trucks = truckService.allFiltersVinMake(vin, make);
        return new Gson().toJson(trucks);
    }


//    @PutMapping(path = "/employees", consumes = "application/json", produces = "application/json")
//    public String createEmployee(@RequestBody Employee emp) {
//        System.out.println(emp);
//        return employeeService.create(emp);
//        }

}
