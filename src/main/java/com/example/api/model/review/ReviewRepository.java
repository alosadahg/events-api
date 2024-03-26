package com.example.api.model.review;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
    List<Review> findByUserid(Integer userid);
    List<Review> findByEventid(Integer eventid);  
    List<Review> findByEventid(Integer eventid, Sort s);
    List<Review> findByUseridAndEventid(Integer userid, Integer eventid); 
}
