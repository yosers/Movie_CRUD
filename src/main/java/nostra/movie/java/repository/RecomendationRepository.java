package nostra.movie.java.repository;

import nostra.movie.java.entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendationRepository extends JpaRepository<Recomendation, Integer> {
}
