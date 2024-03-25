package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.review.Review;
import com.example.api.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {

    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/view-by-event")
    public String getReviewsByEID(Integer eventid) {
        return reviewService.getByEID(eventid);
    }

    @PostMapping("/add")
    public String addReview(
            @RequestParam("userid") Integer userid,
            @RequestParam("eventid") Integer eventid,
            @RequestParam("review") String reviewtext) {
        Review review = new Review(userid, eventid, reviewtext);
        return reviewService.addUserReview(review);
    }

    @PostMapping("/view")
    public String getBySingleReview(Integer userid, Integer eventid) {
        return reviewService.getByUserAndEventID(userid, eventid);
    }
}
