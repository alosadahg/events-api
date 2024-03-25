package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.review.Review;
import com.example.demo.model.review.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepo;

    public String getByEID(Integer eid) {
        List<Review> filtered = reviewRepo.findByEventid(eid);
        if(!filtered.isEmpty()) {
            return filtered.toString();
        } 
        return "No reviews yet";
    }

    public String addUserReview(Review r) {
        if(r!=null) {
            if(reviewRepo.findByUseridAndEventid(r.getUserid(), r.getEventid()).isEmpty()) {
                reviewRepo.save(r);
                return r.toString();
            }
            return "Review already exists";
        }
        return "Transaction failed";
    }

}
