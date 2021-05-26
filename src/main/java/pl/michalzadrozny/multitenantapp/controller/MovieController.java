package pl.michalzadrozny.multitenantapp.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michalzadrozny.multitenantapp.model.Movie;
import pl.michalzadrozny.multitenantapp.repo.MovieRepo;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieController(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id) throws NotFoundException {
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

//    @PostMapping
//    public ResponseEntity<Void> addMovie(@RequestBody Movie movie){
//        movieRepo.save(movie);
//
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
