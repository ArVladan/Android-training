package promo.kit.mycinema.interfaces;

/**
 * Created by Влад on 14.02.17.
 */

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
