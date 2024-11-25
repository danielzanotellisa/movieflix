package com.movieflix.controller;

import com.movieflix.controller.mapper.MovieMapper;
import com.movieflix.controller.request.MovieRequest;
import com.movieflix.controller.response.MovieResponse;
import com.movieflix.entity.Movie;
import com.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @PostMapping("/save")
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie saved = service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(saved));

    }
    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(service.findALl()
                .stream()
                .map(MovieMapper::toMovieResponse).toList());
    }
}
