package org.lessons.java.contoller;

import org.lessons.java.Movie;
import org.lessons.java.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    private List<Movie> getBestMovies() {
        List<Movie> bestMovies = new ArrayList<>();
        // qui aggiungi i tuoi migliori film
        bestMovies.add(new Movie(1L, "il padrino"));
        bestMovies.add(new Movie(2L, "Il padrino 2"));
        bestMovies.add(new Movie(3L, "il padrino 3"));
        return bestMovies;
    }
    private List<Song> getBestSongs() {
        List<Song> bestSongs = new ArrayList<>();
        // qui aggiungi le tue migliori canzoni
        bestSongs.add(new Song(1L, "hai delle isole negli occhi"));
        bestSongs.add(new Song(2L, "sere nere"));
        bestSongs.add(new Song(3L, "tardes negras"));
        return bestSongs;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title", "Andrea");
        return "index";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable(name = "id") int movieId, Model model){
        for(Movie m:getBestMovies()){
            if (m.getId() == movieId){
                model.addAttribute("movie", m);
            }
        }
        //richiamiamo un nuovo file template
        return "movie-details";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable(name = "id") int songId, Model model){
        for(Song s:getBestSongs()){
            if (s.getId() == songId){
                model.addAttribute("song", s);
            }
        }
        //richiamiamo un nuovo file template
        return "song-details";
    }
}
