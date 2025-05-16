package com.data.session09.Controller;


import com.data.session09.model.Movie;
import com.data.session09.model.Schedule;
import com.data.session09.service.MovieService;
import com.data.session09.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/")
    public String home(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/detailMovie")
    public String detailMovie(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        List<Schedule> schedules = scheduleService.findAllScheduleByMovie(movie.getTitle());
        model.addAttribute("movie", movie);
        model.addAttribute("schedules", schedules);
        return "detailMovie";
    }
}