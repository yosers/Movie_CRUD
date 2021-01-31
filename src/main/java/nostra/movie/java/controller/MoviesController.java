package nostra.movie.java.controller;

import io.swagger.annotations.ApiOperation;
import nostra.movie.java.entity.Movies;
import nostra.movie.java.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping("/movies")
    @ApiOperation(value="Show all data movie in page viewMovies")
    public String getAllMovies(Model model) {
        List<Movies> listMovies = moviesService.getAllMovies();

        model.addAttribute("listMovies", listMovies);
        return "viewMovies";
    }

    @GetMapping("/movies/new")
    @ApiOperation(value="Show page createmovie")
    public String createMovies(Model model) {
        model.addAttribute("movies", new Movies());

        return "createMovies";
    }

    @PostMapping("/movie/save")
    @ApiOperation(value="Save data movie based added")
    public String saveMovies(Movies movies) {
        moviesService.createMovies(movies);

        return "redirect:/movies";
    }

    @PostMapping("/movie/update")
    @ApiOperation(value="Change data movie based id")
    public String updateMovies(Movies movies, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/movies";
        }

        moviesService.updateMovies(movies);
        return "redirect:/movies";
    }

    @GetMapping("movie/edit/{id}")
    @ApiOperation(value="Show page edit movie based id")
    public String showEditById(@PathVariable("id") Integer id, Model model) {
        Movies movies = moviesService.getMovieById(id);

        model.addAttribute("movies", movies);
        return "EditMovies";
    }

    @GetMapping("movie/delete/{id}")
    @ApiOperation(value="Delete movie based id")
    public String deleteById(@PathVariable("id") Integer id, Model model) {
         moviesService.deleteMovies(id);

        return "redirect:/movies";
    }
}
