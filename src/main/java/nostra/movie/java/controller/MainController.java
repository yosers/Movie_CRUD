package nostra.movie.java.controller;

import io.swagger.annotations.ApiOperation;
import nostra.movie.java.entity.Movies;
import nostra.movie.java.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    @ApiOperation(value="Show main page")
    public String viewMainMenu() {
        return "index";
    }
}
