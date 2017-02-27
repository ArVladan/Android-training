package promo.kit.mycinema.data;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.support.annotation.NonNull;

import org.json.JSONException;

import java.util.List;
import java.util.MissingResourceException;

import promo.kit.mycinema.data.db.DatabaseRepository;
import promo.kit.mycinema.data.network.MovieAsync;
import promo.kit.mycinema.data.network.MovieNetParser;
import promo.kit.mycinema.data.network.NetworkRepository;
import promo.kit.mycinema.data.utils.NetUtils;
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
    public void fetchMovies(final IListener presenterListener) {
        if (!NetUtils.isNetworkAvailable(context)) {
            List<Movie> dbMovies = db.getAll();
            if (dbMovies != null)
                presenterListener.onResult(dbMovies);
            else presenterListener.onError(new MissingResourceException("", "", ""));
        } else {
            rest.getMoviesApi(new MovieAsync.IResultListener() {
                @Override
                public void onResult(@NonNull String result) {
                    try {
                        List<Movie> fetchedMovies = MovieNetParser.getMoviesFromJson(result);
                        db.saveAll(fetchedMovies);
                        presenterListener.onResult(fetchedMovies);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        presenterListener.onError(e);
                    }
                }

                @Override
                public void onError(String error) {
                    presenterListener.onError(new NetworkErrorException(error));
                }
            });
        }

    }

}