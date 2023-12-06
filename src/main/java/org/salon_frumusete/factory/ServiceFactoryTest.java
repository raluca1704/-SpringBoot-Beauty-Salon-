//package org.salon_frumusete.factory;
//
//import org.salon_frumusete.databasemodell.Service;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class ServiceFactoryTest {
//
//    @Test
//    public void testCreateService() {
//        int serviceID = 1;
//        String name = "Haircut";
//        float price = 30.0f;
//
//        Service service = ServiceFactory.createService(serviceID, name, price);
//
//        assertNotNull(service);
//        assertEquals(serviceID, service.getServiceID());
//        assertEquals(name, service.getName());
//        assertEquals(price, service.getPrice(), 0.001);
//        System.out.println("Service Factory Test Success");
//    }
//
//}
