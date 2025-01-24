package com.movietime.movie_service.repository;

import com.movietime.movie_service.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    List<Movie> movieList = new ArrayList<>();

    public Movie add(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public List<Movie> getAll() {
        return movieList;
    }

    public Movie getById(Long id) {
        return movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
