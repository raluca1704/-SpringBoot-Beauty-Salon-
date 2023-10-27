package repository;

import databasemodell.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {
    private List<Feedback> feedbacks;

    public FeedbackRepository() {
        this.feedbacks = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public Feedback getFeedbackById(int feedbackID) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getFeedbackID() == feedbackID) {
                return feedback;
            }
        }
        return null; // databasemodell.Feedback not found
    }

    public List<Feedback> getAllFeedbacks() {
        return new ArrayList<>(feedbacks); // Return a copy to avoid modifying the internal list
    }

    public void updateFeedback(Feedback updatedFeedback) {
        for (int i = 0; i < feedbacks.size(); i++) {
            if (feedbacks.get(i).getFeedbackID() == updatedFeedback.getFeedbackID()) {
                feedbacks.set(i, updatedFeedback);
                return;
            }
        }
    }

    public void deleteFeedback(int feedbackID) {
        feedbacks.removeIf(feedback -> feedback.getFeedbackID() == feedbackID);
    }
}
