package repository;

import databasemodell.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private List<Service> services;

    public ServiceRepository() {

        this.services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public Service getServiceById(int serviceID) {
        for (Service service : services) {
            if (service.getServiceID() == serviceID) {
                return service;
            }
        }
        return null; // databasemodell.Service not found
    }

    public List<Service> getAllServices() {
        return new ArrayList<>(services); // Return a copy to avoid modifying the internal list
    }

    public void updateService(Service updatedService) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getServiceID() == updatedService.getServiceID()) {
                services.set(i, updatedService);
                return;
            }
        }
    }

    public void deleteService(int serviceID) {
        services.removeIf(service -> service.getServiceID() == serviceID);
    }
}
