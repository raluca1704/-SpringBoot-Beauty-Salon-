package org.salon_frumusete.strategy;

import org.salon_frumusete.databasemodell.Service;

public class ServiceOperationContext {
    private ServiceOperationStrategy operationStrategy;

    public ServiceOperationContext(ServiceOperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void setOperationStrategy(ServiceOperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void executeOperation(Service service) {
        operationStrategy.performOperation(service);
    }
}
