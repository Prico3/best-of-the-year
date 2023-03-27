package org.lessons.java.contoller;

import org.lessons.java.Movie;
import org.lessons.java.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    private List<Movie> getBestMovies() {
        List<Movie> bestMovies = new ArrayList<>();
        // qui aggiungi i film
        bestMovies.add(new Movie(1L, "Il padrino"));
        bestMovies.add(new Movie(2L, "il padrino 2"));
        bestMovies.add(new Movie(3L, "il padrino 3"));
        return bestMovies;
    }
    private List<Song> getBestSongs() {
        List<Song> bestSongs = new ArrayList<>();
        // qui aggiungi le canzoni
        bestSongs.add(new Song(1L, "Hai delle isole negli occhi"));
        bestSongs.add(new Song(2L, "Sere nere"));
        bestSongs.add(new Song(3L, "Tardes negras"));
        return bestSongs;
    }
    @GetMapping()
    public String home(Model model){
        model.addAttribute("name", "Andrea");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> bestMovies = getBestMovies();
        String titles = bestMovies.stream().map(Movie::getTitle).collect(Collectors.joining(", "));
        model.addAttribute("titles", titles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> bestSongs = getBestSongs();
        String titles = bestSongs.stream().map(Song::getTitle).collect(Collectors.joining(", "));
        model.addAttribute("titles", titles);
        return "songs";
    }
}
