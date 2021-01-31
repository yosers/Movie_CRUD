package nostra.movie.java.service;

import nostra.movie.java.entity.Favorite;
import nostra.movie.java.repository.FavoriteRepository;
import nostra.movie.java.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite createFavorite(Favorite favorite) {
        return  favoriteRepository.save(favorite);
    }

    public Favorite getFavoriteById(int id) {
        return  favoriteRepository.findById(id).get();
    }

    public List<Favorite> getAllFavorite() {
        return favoriteRepository.findAll();
    }
}
