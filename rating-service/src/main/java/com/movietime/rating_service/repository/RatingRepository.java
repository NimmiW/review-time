package com.movietime.rating_service.repository;

import com.movietime.rating_service.model.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RatingRepository {
    private List<Rating> ratings = new ArrayList<>();

    public Rating add(Rating rating) {
        ratings.add(rating);
        return rating;
    }

    public List<Rating> getAll() {
        return ratings;
    }

    public Rating findById(Long id) {
        return ratings.stream()
                .filter(rating -> rating.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
