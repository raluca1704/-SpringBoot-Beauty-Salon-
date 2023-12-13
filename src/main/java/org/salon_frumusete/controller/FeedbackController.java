package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Feedback;
import org.salon_frumusete.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping("/{feedbackId}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackRepository.findAll());
    }

    @PutMapping("/{feedbackId}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int feedbackId, @RequestBody Feedback feedbackDetails) {
        return feedbackRepository.findById(feedbackId)
                .map(feedback -> {
                    feedback.setDescription(feedbackDetails.getDescription());
                    feedback.setStars(feedbackDetails.getStars());
                    feedback.setClientID(feedbackDetails.getClientID());
                    return ResponseEntity.ok(feedbackRepository.save(feedback));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable int feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .map(feedback -> {
                    feedbackRepository.delete(feedback);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}