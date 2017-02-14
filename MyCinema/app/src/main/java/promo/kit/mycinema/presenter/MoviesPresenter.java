package promo.kit.mycinema.presenter;

import android.content.Context;

import promo.kit.mycinema.data.db.DataRepository;
import promo.kit.mycinema.interfaces.MVPMovie;



public class MoviesPresenter implements MVPMovie.MoviesPresenter {
    private MVPMovie.MoviesView view;
    private final MVPMovie.MoviesModel model;

    public MoviesPresenter(Context context) {
        model = new DataRepository(context);
    }


    @Override
    public void setView(MVPMovie.MoviesView view) {


    }

    @Override
    public void getMovies() {

    }

    @Override
    public void onMovieSelected(int id) {

    }
}
