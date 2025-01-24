package com.movietime.movie_service.controller;

import com.movietime.movie_service.model.Movie;
import com.movietime.movie_service.model.Rating;
import com.movietime.movie_service.repository.MovieRepository;
import com.movietime.movie_service.webclient.RatingWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieRepository.add(movie);
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieRepository.getById(id);
    }

    @Autowired
    private RatingWebClient ratingWebClient;


    @GetMapping("/{movieId}/ratings")
    public List<Rating> getRating(@PathVariable Long movieId){
        List<Rating> ratings = ratingWebClient.getAll();
        System.out.println(ratings);

        return ratings.stream()
                .filter(rating -> rating.getMovieId().equals(movieId))
                .toList();
    }

}
