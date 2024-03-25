package com.example.demo.model.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
    List<Review> findByUserid(Integer userid);
    List<Review> findByEventid(Integer eventid);  
    List<Review> findByUseridAndEventid(Integer userid, Integer eventid); 
}
