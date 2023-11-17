package com.example.movies.Controller;

import com.example.movies.Entity.Movie;
import com.example.movies.Repository.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(service.allMovies());
    }

    @GetMapping("/movieId/{id}")
    public ResponseEntity<Optional<Movie>> getByMovieId(@PathVariable ObjectId id) {
        return ResponseEntity.ok(service.getByMovieId(id));
    }

    @GetMapping("/ImdbId/{id}")
    public ResponseEntity<Optional<Movie>> getByImdbId(@PathVariable String id) {
        return ResponseEntity.ok(service.getByImdbId(id));
    }
}
