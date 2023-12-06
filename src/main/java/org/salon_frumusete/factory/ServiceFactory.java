package org.salon_frumusete.factory;

import org.salon_frumusete.databasemodell.Service;

public class ServiceFactory {

    public static Service createService(int serviceID, String name, float price) {
        Service service = new Service();
        service.setServiceID(serviceID);
        service.setName(name);
        service.setPrice(price);
        return service;
    }

}