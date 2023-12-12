package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNameContaining(String name);
}