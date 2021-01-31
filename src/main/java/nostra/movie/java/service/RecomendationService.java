package nostra.movie.java.service;

import nostra.movie.java.entity.Movies;
import nostra.movie.java.entity.Recomendation;
import nostra.movie.java.repository.MoviesRepository;
import nostra.movie.java.repository.RecomendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendationService {
    @Autowired
    private RecomendationRepository recomendationRepository;

    public Recomendation createRecomendation(Recomendation recomendation) {
        return  recomendationRepository.save(recomendation);
    }

    public List<Recomendation> getAllRecomendation() {
        return recomendationRepository.findAll();
    }

    public String deleteRecomendation(int id) {
        recomendationRepository.deleteById(id);

        return "Recomendation with ID:" + id + " Deleted";
    }
}
