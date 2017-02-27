package promo.kit.mycinema.presenter;

import android.content.Context;

import java.util.List;

import promo.kit.mycinema.data.DataRepository;
import promo.kit.mycinema.interfaces.IListener;
import promo.kit.mycinema.interfaces.MVPMovie;
import promo.kit.mycinema.model.Movie;


public class MoviePresent implements MVPMovie.MoviesPresenter {
    private MVPMovie.MoviesView view;
    private final MVPMovie.MoviesModel model;

    public MoviePresent(Context context) {
        model = new DataRepository(context);
    }

    @Override
    public void setView(MVPMovie.MoviesView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        model.fetchMovies(new IListener() {
            @Override
            public void onResult(List<Movie> movies) {
                if (MoviePresent.this.view != null){
                    MoviePresent.this.view.onMoviesReceived(movies);
                }
            }

            @Override
            public void onError(Exception e) {
                if (MoviePresent.this.view != null) {
                    MoviePresent.this.view.onError(e.getLocalizedMessage());
                }
            }
        });

    }

    @Override
    public void onMovieSelected(int id) {

    }
}