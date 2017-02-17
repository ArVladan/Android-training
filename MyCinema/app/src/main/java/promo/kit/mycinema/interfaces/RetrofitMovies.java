package promo.kit.mycinema.interfaces;

import java.util.List;

import promo.kit.mycinema.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Влад on 17.02.17.
 */

public interface RetrofitMovies {
    @GET("/3/discover/movie")
    Call<List<Movie>> getData(@Query("id") String id, @Query("poster_path") String posterPath, @Query("release_date") String releaseDate);

}
