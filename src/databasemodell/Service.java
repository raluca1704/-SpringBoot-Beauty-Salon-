package databasemodell;

public class Service {

    private int serviceID;
    private int jobTypID;
    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getJobTypID() {
        return jobTypID;
    }

    public void setJobTypID(int jobTypID) {
        this.jobTypID = jobTypID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

}
