package org.salon_frumusete;

import org.salon_frumusete.controller.*;
import org.salon_frumusete.databasemodell.Appointment;
import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.databasemodell.Employee;
import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.factory.ServiceFactory;
import org.salon_frumusete.repository.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = "org.salon_frumusete.decorator")
@ComponentScan(basePackages = {"org.salon_frumusete.repository","org.salon_frumusete.controller"})

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
       
    }
}