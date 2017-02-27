package promo.kit.mycinema.data.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import promo.kit.mycinema.data.Constants;
import promo.kit.mycinema.model.Movie;


public class MovieNetParser {
    public static final String LOG_TAG = MovieNetParser.class.getSimpleName();
    private static final String KEY_RESULTS = "results";

    //Take the String representing the complete movies in JSON Format and get list of  MovieItem.

    public static List<Movie> getMoviesFromJson(String json) throws JSONException {

        JSONObject forecastJson = new JSONObject(json);
        JSONArray jsonMoviesArray = forecastJson.getJSONArray(KEY_RESULTS);

        List<Movie> movies = new ArrayList<>(Constants.MOVIE_COUNT);

        int length = forecastJson.length() < Constants.MOVIE_COUNT ? forecastJson.length() : Constants.MOVIE_COUNT;
        for(int i = 0; i < Constants.MOVIE_COUNT; i++) {
            Movie movie = new Movie();
            JSONObject jsonMovie = jsonMoviesArray.getJSONObject(i);
            movie.title = jsonMovie.getString(Movie.KEY_TITLE);
            movie.overview = jsonMovie.getString(Movie.KEY_OVERVIEW);
            movie.posterPath = jsonMovie.getString(Movie.KEY_POSTER_PATH);
            movie.releaseDate = jsonMovie.getString(Movie.KEY_RELEASE_DATE);
            movie.popularity = jsonMovie.getDouble(Movie.KEY_RATE);

            movies.add(movie);
        }

        return movies;
    }
}
