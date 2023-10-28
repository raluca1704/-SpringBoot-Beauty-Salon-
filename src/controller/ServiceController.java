package controller;

import databasemodell.Service;
import repository.ServiceRepository;

import java.util.List;

public class ServiceController {
    private ServiceRepository serviceController;

    public ServiceController() {
        this.serviceController = new ServiceRepository();
    }

    public void addService(Service service) {
        serviceController.addService(service);
    }

    public Service getServiceById(int serviceID) {
        return serviceController.getServiceById(serviceID);
    }

    public List<Service> getAllServices() {
        return serviceController.getAllServices();
    }

    public void updateService(Service updatedService) {
        serviceController.updateService(updatedService);
    }

    public void deleteService(int serviceID) {
        serviceController.deleteService(serviceID);
    }
}
