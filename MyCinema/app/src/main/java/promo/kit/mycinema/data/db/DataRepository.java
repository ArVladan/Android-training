package promo.kit.mycinema.data.db;

import android.content.Context;

import promo.kit.mycinema.data.DatabaseRepository;
import promo.kit.mycinema.data.network.NetworkRepository;
import promo.kit.mycinema.interfaces.IListener;
import promo.kit.mycinema.interfaces.MVPMovie;


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
        
    }
}
