package org.salon_frumusete.factory;

import org.junit.jupiter.api.Test;
import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.factory.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ServiceFactoryTest {

    @Autowired
    private ServiceFactory serviceFactory;

    @Test
    public void testCreateService() {
        int serviceID = 21;
        String name = "Hairsomething";
        float price = 30.0f;

        Service service = serviceFactory.createService(serviceID, name, price);

        assertNotNull(service);
        assertEquals(serviceID, service.getServiceID());
        assertEquals(name, service.getName());
        assertEquals(price, service.getPrice(), 0.001);
        System.out.println("Service Factory Integration Test Success");
    }
}
