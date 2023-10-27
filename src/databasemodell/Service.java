package databasemodell;

public class Service {

    private int serviceID;
    private String jobTypname;
    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getJobTypname() {
        return jobTypname;
    }

    public void setJobTypname(String jobTypname) {
        this.jobTypname = jobTypname;
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
