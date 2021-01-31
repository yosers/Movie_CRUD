package nostra.movie.java.service;

import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.User;
import nostra.movie.java.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public Movies createMovies(Movies movies) {
        return  moviesRepository.save(movies);
    }

    public Movies getMovieById(int id) {
        return  moviesRepository.findById(id).get();
    }

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public List<Movies> getMoviesByName(String nameMovies) {
        return moviesRepository.findByNameMovies(nameMovies);
    }

    public String deleteMovies(int id) {
        moviesRepository.deleteById(id);

        return "Movies with ID:" + id + " Deleted";
    }

    public Movies updateMovies(Movies movies) {
        Movies dataMovies =  moviesRepository.findById(movies.getIdMovies()).orElse(null);
        dataMovies.setNameMovies(movies.getNameMovies());
        dataMovies.setImage(movies.getImage());
        dataMovies.setDescription(movies.getDescription());
        dataMovies.setRealseDate(movies.getRealseDate());

        return  moviesRepository.save(dataMovies);
    }
}
