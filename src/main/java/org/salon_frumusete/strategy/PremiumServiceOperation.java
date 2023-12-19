package org.salon_frumusete.strategy;

import org.salon_frumusete.databasemodell.Service;

public class PremiumServiceOperation implements ServiceOperationStrategy {
    @Override
    public void performOperation(Service service) {
        // Implementați logica pentru operația premium
        System.out.println("Performing premium operation for service: " + service.getName());
    }
}