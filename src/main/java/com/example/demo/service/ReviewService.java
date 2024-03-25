package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.review.Review;
import com.example.demo.model.review.ReviewRepository;
import com.example.demo.model.event.Event;
import com.example.demo.model.event.EventRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private EventRepository eventRepo;

    public String getByEID(Integer eid) {
        List<Review> filtered = reviewRepo.findByEventid(eid);
        if (!filtered.isEmpty()) {
            return filtered.toString();
        }
        return "No reviews yet";
    }

    public String addUserReview(Review r) {
        if (r != null) {
            if (reviewRepo.findByUseridAndEventid(r.getUserid(), r.getEventid()).isEmpty()) {
                reviewRepo.save(r);
                int userid = r.getUserid();
                int eid = r.getEventid();
                Event e = eventRepo.findById(eid).get();
                if (e.getReviews() == null) {
                    e.setReviews(new Integer[0]);
                }
                Integer[] reviews = e.getReviews();
                Integer[] updated = Arrays.copyOf(reviews, reviews.length + 1);
                updated[reviews.length] = userid;
                e.setReviews(updated);
                eventRepo.save(e);
                return r.toString();
            }
            return "Review already exists";
        }
        return "Transaction failed";
    }

    public String getByUserAndEventID(Integer userid, Integer eventid) {
        if (!reviewRepo.findByUseridAndEventid(userid, eventid).isEmpty()) {
            return reviewRepo.findByUseridAndEventid(userid, eventid).get(0).toString();
        }
        return "Record not found";
    }

}
