package io.trucker.Service;

import io.trucker.Entity.Alert;
import io.trucker.Entity.TruckData;

public interface AlertService {
    Alert createAlert(TruckData truckData);
}
