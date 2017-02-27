package promo.kit.mycinema.data;


import promo.kit.mycinema.BuildConfig;

public class Constants {
    public static final int MOVIE_COUNT = 20;
    public static final String URL_FETCH_MOVIES =
            "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key="+ BuildConfig.API_KEY + "&language=ru";
}