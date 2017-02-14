package promo.kit.mycinema.data.db;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.MissingResourceException;

import promo.kit.mycinema.data.DatabaseRepository;
import promo.kit.mycinema.data.network.NetworkRepository;
import promo.kit.mycinema.interfaces.IListener;
import promo.kit.mycinema.interfaces.MVPMovie;
import promo.kit.mycinema.model.Movie;


public class DataRepository implements MVPMovie.MoviesModel {
    private final Context context;
    private final DatabaseRepository db;
    private final NetworkRepository rest;

    public DataRepository(Context context) {
        this.context = context;
        db = new DatabaseRepository(context);
        rest = new NetworkRepository(context);
    }

    @Override
    public void fetchMovies(IListener resultListener) {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            List<Movie> dbMovies = db.getAll();
            if (dbMovies != null)
                presenterListener.onResult(dbMovies);
            else presenterListener.onError(new MissingResourceException("", "", ""));
        } else {
            rest.getMoviesApi(new MovieFetcherAsync.IResultListener() {
                @Override
                public void onResult(@NonNull String result) {
                    try {
                        List<Movie> fetchedMovies = MovieNetworkParser.getMoviesFromJson(result);
                        db.saveAll(fetchedMovies);
                        presenterListener.onResult(fetchedMovies);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        presenterListener.onError(e);
                    }
    }
}
