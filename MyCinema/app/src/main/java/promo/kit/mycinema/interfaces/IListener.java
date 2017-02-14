package promo.kit.mycinema.interfaces;

import java.util.List;

import promo.kit.mycinema.model.Movie;

public interface IListener {
    void onResult(List<Movie> movies);
    void onError(Exception e);
}
