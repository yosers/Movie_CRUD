package nostra.movie.java.service;

import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.User;
import nostra.movie.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id) {
        return  userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);

        return "User with ID:" + id + " Deleted";
    }

}
