package factory;

import databasemodell.Service;

public class ServiceFactory {

    public static Service createService(int serviceID, String name, float price) {
        Service service = new Service();
        service.setServiceID(serviceID);
        service.setName(name);
        service.setPrice(price);
        return service;
    }

}