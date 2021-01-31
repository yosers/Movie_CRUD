package nostra.movie.java.controller;

import io.swagger.annotations.ApiOperation;
import nostra.movie.java.entity.Favorite;
import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.User;
import nostra.movie.java.service.FavoriteService;
import nostra.movie.java.service.MoviesService;
import nostra.movie.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private MoviesService moviesService;

    @GetMapping("user/favorite/{id}")
    @ApiOperation(value="Menampilkan semua data favorite berdasarkan id")
    public String getAllFavorite(@PathVariable("id") Integer id, Model model) {
        List<Favorite> listFavorite = favoriteService.getAllFavorite();
        User userById = userService.getUserById(id);

        model.addAttribute("user", userById);
        model.addAttribute("listFavorite", listFavorite);
        return "viewFavorite";
    }

    @GetMapping("/favorite/new/{id}")
    @ApiOperation(value="Menampilkan halaman createFavorite dan membawa id user")
    public String createFavorite(@PathVariable("id") Integer id, Model model) {
        User userById = userService.getUserById(id);
        List<Movies> listMovies = moviesService.getAllMovies();

        model.addAttribute("listMovies", listMovies);
        model.addAttribute("user", userById);
        model.addAttribute("favorite", new Favorite());

        return "createFavorite";
    }

    @PostMapping("/favorite/save")
    public String saveMovies(Favorite favorite) {
        //moviesService.createMovies(movies);

        return "redirect:/movies";
    }
}
