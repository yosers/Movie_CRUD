package nostra.movie.java.controller;

import io.swagger.annotations.ApiOperation;
import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.User;
import nostra.movie.java.repository.UserRepository;
import nostra.movie.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ApiOperation(value="Show all data user")
    public String getAllUser (Model model) {
        List<User> user = userService.getAllUser();

        model.addAttribute("user", user);
        return "viewUsers";
    }

    @GetMapping("/user/new")
    @ApiOperation(value="Show page createuser")
    public String createUsers(Model model) {
        model.addAttribute("user", new User());

        return "createUsers";
    }

    @PostMapping("/user/save")
    @ApiOperation(value="Save user based added")
    public String saveUser(User user) {
        userService.saveUser(user);

        return "redirect:/user";
    }

    @GetMapping("user/edit/{id}")
    @ApiOperation(value="Show page edit user based id")
    public String showEditById(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "EditUser";
    }

    @PostMapping("/user/update")
    @ApiOperation(value="Change data user based id")
    public String updateUser(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/user";
        }
        else {
                User dataUser =  userService.getUserById(user.getIdUser());
                dataUser.setName(user.getName());
                dataUser.setEmail(user.getEmail());
                dataUser.setPhone(user.getPhone());
        }
        userService.saveUser(user);

        return "redirect:/user";
    }

    @GetMapping("user/delete/{id}")
    @ApiOperation(value="Delete user based id")
    public String deleteById(@PathVariable("id") Integer id, Model model) {
        userService.deleteUser(id);

        return "redirect:/user";
    }
}
