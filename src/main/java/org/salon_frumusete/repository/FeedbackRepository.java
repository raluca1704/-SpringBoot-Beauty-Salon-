package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    // Additional custom methods if needed
}