package promo.kit.mycinema.interfaces;

import java.util.List;

import promo.kit.mycinema.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RetrofitMovies {
    @GET("/3/discover/movie")
    Call<List<Movie>> getData(
            @Query("sort_by") String sortBy,
            @Query("api_key") String apiKey);
}
