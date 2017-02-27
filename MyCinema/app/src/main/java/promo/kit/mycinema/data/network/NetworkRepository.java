package promo.kit.mycinema.data.network;

import android.content.Context;

import promo.kit.mycinema.data.Constants;

public class NetworkRepository {
    private final Context context;

    public NetworkRepository(Context context) {
        this.context = context;
    }

    public void getMoviesApi(MovieAsync.IResultListener listener) {
        new MovieAsync(listener).execute(Constants.URL_FETCH_MOVIES);
    }
}
