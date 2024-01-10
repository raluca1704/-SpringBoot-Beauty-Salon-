package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContaining(String name);
    List<Employee> findByOrderByRatingDesc();
}