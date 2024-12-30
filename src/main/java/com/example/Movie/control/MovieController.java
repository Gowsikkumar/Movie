package com.example.Movie.control;

import com.example.Movie.model.Movie;
import com.example.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Home route
    @GetMapping("/")
    public String open(Model model) {
        model.addAttribute("movie", new Movie());
        return "index";
    }

    // Create movie
    @PostMapping("/new")
    public String newMovie(@ModelAttribute("movie") Movie movie, Model model) {
        movieService.create(movie);
        model.addAttribute("movies", movieService.Read());
        return "success";
    }

    // Delete movie by ID
//    @GetMapping("/del/{id}")
//    public String delete(@PathVariable("id") Long id, Model model) {
//        movieService.deleteById(id);
//        model.addAttribute("movies", movieService.read());
//        return "success";
//    }
//
//    // Edit movie by ID
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Optional<Movie> movie = movieService.getById(id);
//        if (movie.isPresent()) {
//            model.addAttribute("movie", movie.get());
//        }
//        return "edit";  // Returns the edit view to update movie
//    }
//
//    // Update movie by ID
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") Long id, @ModelAttribute Movie movie, Model model) {
//        movie.setId(id);  // Ensure the ID is set for update
//        movieService.update(movie);  // Update the movie (use update, not create)
//        model.addAttribute("movies", movieService.read());
//        return "success";  // Redirect to the success page
//    }
}
