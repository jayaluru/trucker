package io.trucker.Service;

import io.trucker.Entity.Alert;
import io.trucker.Entity.Truck;
import io.trucker.Entity.TruckData;
import io.trucker.Repository.AlertRepository;
import io.trucker.Repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    TruckRepository truckRepository;
    @Autowired
    AlertRepository alertRepository;

    @Override
    public Alert createAlert (TruckData truckData)
    {
        Optional<Truck> truck = truckRepository.findById(truckData.getVin());
        System.out.println("inside createAlert");
        Alert alert = new Alert();
        String rule = "";
        String priority = "";

        String rpm = rpmRule(truckData, truck);
        String fuel = fuelRule(truckData, truck);
        String tire = tireRule(truckData, truck);
        String other = otherRule(truckData, truck);

        if(rpm!=null){
            priority = "HIGH";
        }else if(fuel!=null){
            priority = "MEDIUM";
        }else if(tire!=null){
            priority = "LOW";
        }else if(other!=null){
            priority = "LOW";
        }

        if(rpm!=null){
            rule = rpm;
        }if(fuel!=null){
            rule = rule + " & " + fuel;
        }if(tire!=null){
            rule = rule + " & " + tire;
        }if(other!=null){
            rule = rule + " & " + other;
        }

        alert.setPriority(priority);
        alert.setRule(rule);
        alert.setTimeStamp(truckData.getTimestamp());
        alert.setVin(truckData.getVin());

        System.out.println(alert);
        //return null;
        return alertRepository.save(alert);
    }

    public String rpmRule(TruckData truckData, Optional<Truck> truck){
        String str ="";
            if(truckData.getEngineRpm() > truck.get().getRedlineRpm()){
                str = "Engine RPM > RedLine RPM";
                return str;
            }
        return null;
    }
    public String fuelRule(TruckData truckData, Optional<Truck> truck){
        String str ="";
        if(truckData.getFuelVolume() < (truck.get().getMaxFuelVolume()/10)){
            str = "Engine Fuel < 10% Max Fuel";
            return str;
        }
        return null;
    }
    public String tireRule(TruckData truckData, Optional<Truck> truck){
        String str ="";
        int[] tirePres = truckData.getTires().getTirePressureArray();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int tp: tirePres){
            if(max<tp){max = tp;}
            if(min>tp){min = tp;}
        }
        if(max > 36 || min < 32){
            str = "Abnormal tire pressure";
            return str;
        }
        return null;
    }
    public String otherRule(TruckData truckData, Optional<Truck> truck){
        String str ="";
        if(truckData.isEngineCoolantLow() == true || truckData.isCheckEngineLightOn() == true){
            str = "Coolant low or Engine on";
            return str;
        }
        return null;
    }
}
