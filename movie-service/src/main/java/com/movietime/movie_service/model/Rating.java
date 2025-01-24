package com.movietime.movie_service.model;

public class Rating {
    private Long Id;
    private Long movieId;
    private int rating;

    private Rating(){

    }

    private Rating(Long id, Long movieId, int rating) {
        Id = id;
        this.movieId = movieId;
        this.rating = rating;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

