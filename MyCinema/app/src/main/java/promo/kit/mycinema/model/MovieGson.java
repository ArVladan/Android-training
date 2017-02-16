package promo.kit.mycinema.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



import java.util.List;

public class MovieGson {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("mMovies")
    @Expose
    private List<Movie> mMovies = null;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;



    /**
     * No args constructor for use in serialization
     *
     */
    public MovieGson() {
    }

    /**
     *
     * @param movies
     * @param totalResults
     * @param page
     * @param totalPages
     */
    public MovieGson(Integer page, List<Movie> movies, Integer totalResults, Integer totalPages) {
        super();
        this.page = page;
        this.mMovies = movies;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        this.mMovies = movies;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }



}