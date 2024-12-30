package com.example.Movie.service;

import com.example.Movie.model.Movie;
import com.example.Movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> getAllmovieRepository() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public void update(Movie movie) {
        movieRepository.save(movie);  // Save works for both create and update in JPA
    }
}
