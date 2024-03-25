package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.review.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewContoller {

    @Autowired
    private final ReviewService reviewService;

    public ReviewContoller(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/view-all")
    public String getReviewsByEID(Integer eid) {
        return reviewService.getByEID(eid);
    }

    @PostMapping("/add")
    public String addReview(Review r) {
        return reviewService.addUserReview(r);
    }
}
