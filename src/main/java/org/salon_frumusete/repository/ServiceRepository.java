package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findByNameContaining(String name);
}