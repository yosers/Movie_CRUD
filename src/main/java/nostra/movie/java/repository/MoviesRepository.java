package nostra.movie.java.repository;

import nostra.movie.java.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    List<Movies> findByNameMovies(String nameMovies);
}
