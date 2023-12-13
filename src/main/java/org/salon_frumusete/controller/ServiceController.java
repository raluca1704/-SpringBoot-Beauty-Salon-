package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        Service savedService = serviceRepository.save(service);
        return ResponseEntity.ok(savedService);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<Service> getServiceById(@PathVariable int serviceId) {
        return serviceRepository.findById(serviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        return ResponseEntity.ok(serviceRepository.findAll());
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<Service> updateService(@PathVariable int serviceId, @RequestBody Service serviceDetails) {
        return serviceRepository.findById(serviceId)
                .map(service -> {
                    service.setName(serviceDetails.getName());
                    service.setPrice(serviceDetails.getPrice());
                    return ResponseEntity.ok(serviceRepository.save(service));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable int serviceId) {
        return serviceRepository.findById(serviceId)
                .map(service -> {
                    serviceRepository.delete(service);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Service>> getServicesByName(@RequestParam String name) {
        return ResponseEntity.ok(serviceRepository.findByNameContaining(name));
    }

    // Note: The performService method that was delegating operation to a strategy pattern is not typically a part of REST API design.
    // You may want to handle such operations through a different mechanism, depending on your application's architecture.
}