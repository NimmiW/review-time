package com.movietime.movie_service.webclient;

import com.movietime.movie_service.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface RatingWebClient {
    @GetExchange("/rating")
    public List<Rating> getAll();
}
