package org.lessons.java.controllers;


import org.lessons.java.models.Movie;
import org.lessons.java.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;




@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Andrea");
        model.addAttribute("content", "home");
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";

    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();
        Movie selectedMovie = movies.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
        model.addAttribute("movie", selectedMovie);
        return "movie-detail";
    }
    

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable int id, Model model) {
        List<Song> songs = getBestSongs();
        Song selectedSong = songs.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        model.addAttribute("song", selectedSong);
        return "song-detail";
    }
    
    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Ritorno al futuro 1"));
        movies.add(new Movie(2, "Ritorno al futuro 2"));
        movies.add(new Movie(3, "Ritorno al futuro 3"));
        movies.add(new Movie(4, "Rocky 1"));
        movies.add(new Movie(5, "Rocky 2"));
        return movies;
    };
    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Leanin"));
        songs.add(new Song(2, "Ancora qua"));
        songs.add(new Song(3, "Non mi ricordo di te"));
        songs.add(new Song(4, "Hard"));
        songs.add(new Song(5, "Tutti i giorni"));
        return songs;
    };
    
    
}
