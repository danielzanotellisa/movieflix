package com.movieflix.service;

import com.movieflix.entity.Movie;
import com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> findALl() {
        return repository.findAll();
    }
}
