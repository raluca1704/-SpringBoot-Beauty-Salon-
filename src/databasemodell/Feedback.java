package databasemodell;

public class Feedback {
    private int feedbackID;
    private int clientID;
    private String description;
    private float stars;
    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }



}
