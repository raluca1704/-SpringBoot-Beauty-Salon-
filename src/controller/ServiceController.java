package controller;

import databasemodell.Service;
import repository.ServiceRepository;

import java.util.List;

public class ServiceController {
    private ServiceRepository serviceRepository;
    public ServiceController(ServiceRepository serviceRepository) {
        this. serviceRepository = serviceRepository;
    }

    public void addService(Service service) {
        serviceRepository.addService(service);
    }

    public Service getServiceById(int serviceID) {
        return serviceRepository.getServiceById(serviceID);
    }

    public List<Service> getAllServices() {
        return serviceRepository.getAllServices();
    }

    public void updateService(Service updatedService) {
        serviceRepository.updateService(updatedService);
    }

    public void deleteService(int serviceID) {
        serviceRepository.deleteService(serviceID);
    }
}
