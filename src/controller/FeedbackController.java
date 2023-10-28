package controller;

import databasemodell.Feedback;
import repository.FeedbackRepository;

import java.util.List;

public class FeedbackController {
    private FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository =feedbackRepository;
    }

    public void addFeedback(Feedback feedback) {
        feedbackRepository.addFeedback(feedback);
    }

    public Feedback getFeedbackById(int feedbackID) {
        return feedbackRepository.getFeedbackById(feedbackID);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.getAllFeedbacks();
    }

    public void updateFeedback(Feedback updatedFeedback) {
        feedbackRepository.updateFeedback(updatedFeedback);
    }

    public void deleteFeedback(int feedbackID) {
        feedbackRepository.deleteFeedback(feedbackID);
    }
}
