package org.salon_frumusete.strategy;

import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.strategy.ServiceOperationStrategy;

public class StandardServiceOperation implements ServiceOperationStrategy {
    @Override
    public void performOperation(Service service) {
        // Implementați logica pentru operația standard
        System.out.println("Performing standard operation for service: " + service.getName());
    }
}



