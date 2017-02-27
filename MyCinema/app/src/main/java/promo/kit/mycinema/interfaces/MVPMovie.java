package promo.kit.mycinema.interfaces;

import java.util.List;

import promo.kit.mycinema.model.Movie;

public interface MVPMovie {
    interface MoviesView {
        void onMoviesReceived(List<Movie> movies);
        void onError(String error);
    }

    interface MoviesPresenter {
        void setView(MoviesView view);
        void getMovies();
        void onMovieSelected(int id);
    }

    interface MoviesModel {
        void fetchMovies(IListener resultListener);
    }
}
