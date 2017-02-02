package promo.kit.mycinema.model;

/**
 * Created by Влад on 15.01.17.
 */
import java.util.List;

public class MovieData {

    private int page;
    private List<Movie> mMovieMovies = null;
    private int totalResults;
    private int totalPages;

    /**
     * No args constructor for use in serialization
     *
     */
    public MovieData() {
    }

    /**
     *
     * @param movieMovies
     * @param totalResults
     * @param page
     * @param totalPages
     */
    public MovieData(int page, List<Movie> movieMovies, int totalResults, int totalPages) {
        super();
        this.page = page;
        this.mMovieMovies = movieMovies;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovieMovies() {
        return mMovieMovies;
    }

    public void setMovieMovies(List<Movie> movieMovies) {
        this.mMovieMovies = movieMovies;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }



}
