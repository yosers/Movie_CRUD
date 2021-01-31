package nostra.movie.java.controller;

import io.swagger.annotations.ApiOperation;
import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.Recomendation;
import nostra.movie.java.service.MoviesService;
import nostra.movie.java.service.RecomendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecomendationController {
    @Autowired
    private RecomendationService recomendationService;

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/recomendation")
    @ApiOperation(value="Show all data in page recomendationmovie")
    public String getAllMovies(Model model) {
        List<Recomendation> listRecomendation = recomendationService.getAllRecomendation();

        model.addAttribute("listRecomendation", listRecomendation);
        return "viewMovies";
    }

    @GetMapping("/recomendation/new")
    @ApiOperation(value="Show page createRecomendation")
    public String createMovies(Model model) {
        List<Movies> listMovies = moviesService.getAllMovies();

        model.addAttribute("recomendation", new Recomendation());
        model.addAttribute("listMovies", listMovies);
        return "createRecomendation";
    }

    @PostMapping("/recomendation/save")
    @ApiOperation(value="Save data based added")
    public String saveMovies(Recomendation recomendation) {
        recomendationService.createRecomendation(recomendation);

        return "redirect:/movies";
    }
}
