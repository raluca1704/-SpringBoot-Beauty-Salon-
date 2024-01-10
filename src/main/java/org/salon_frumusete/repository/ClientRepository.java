package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.controller.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.Callable;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNameContaining(String name);


}