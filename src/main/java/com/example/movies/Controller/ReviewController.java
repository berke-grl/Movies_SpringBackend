package com.example.movies.Controller;

import com.example.movies.Entity.Review;
import com.example.movies.Repository.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class ReviewController {
    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(service.createReview(payload.get("reviewBody"), payload.get("imdbId")));
    }

}
