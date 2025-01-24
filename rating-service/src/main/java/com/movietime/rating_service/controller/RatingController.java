package com.movietime.rating_service.controller;

import com.movietime.rating_service.model.Rating;
import com.movietime.rating_service.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping
    public Rating add(@RequestBody Rating rating) {
        ratingRepository.add(rating);
        return rating;
    }

    @GetMapping
    public List<Rating> getAll() {
        return ratingRepository.getAll();
    }

    @GetMapping("/{id}")
    public Rating getById(@PathVariable Long id) {
        return ratingRepository.findById(id);
    }
}
