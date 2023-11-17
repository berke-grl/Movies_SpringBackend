package com.example.movies.Repository;

import com.example.movies.Entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> allMovies() {
        return repository.findAll();
    }

    public Optional<Movie> getByMovieId(ObjectId id) {
        return repository.findById(id);
    }
    public Optional<Movie> getByImdbId(String  id) {
        return repository.findMovieByImdbId(id);
    }

}
