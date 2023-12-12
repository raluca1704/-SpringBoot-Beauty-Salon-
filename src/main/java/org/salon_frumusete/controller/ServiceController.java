package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.repository.ServiceRepository;
import org.salon_frumusete.strategy.ServiceStrategy;

import java.util.List;

public class ServiceController {
    private ServiceStrategy serviceStrategy;

    public void setServiceStrategy(ServiceStrategy serviceStrategy) {
        this.serviceStrategy = serviceStrategy;
    }

    public void performService() {
        // Delegates the operation to the strategy
        if (serviceStrategy != null) {
            serviceStrategy.performService();
        }
    }
    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
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

    public List<Service> getServicesByName(String name) {
        return serviceRepository.getServicesByName(name);

    }

    public float getServicePriceById(int serviceID) {
        return serviceRepository.getServicePriceById(serviceID);
    }
    public String getServiceNameById(int serviceID) {
        return serviceRepository.getServiceNameById(serviceID);
    }


    }
