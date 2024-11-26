package com.movieflix.service;

import com.movieflix.entity.Category;
import com.movieflix.entity.Movie;
import com.movieflix.entity.Streaming;
import com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findALl() {
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie updateMovie) {
        Optional<Movie> optMovie = repository.findById(movieId);
        if(optMovie.isPresent()) {

            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

            Movie movie = optMovie.get();

            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);

            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public List<Movie> findByCategory(Long categoryId) {
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(c -> categoryService.findCategoryById(c.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach
                (s -> streamingService.findStreamingById(s.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }
}
