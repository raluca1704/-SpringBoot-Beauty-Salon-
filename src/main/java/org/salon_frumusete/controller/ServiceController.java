package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.repository.ServiceRepository;

import java.util.List;

public class ServiceController {
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
