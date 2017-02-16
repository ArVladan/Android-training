package promo.kit.mycinema.model;

import android.database.Cursor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result extends MovieGson {

    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("release_date")
    @Expose
    public String releaseDate;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Float voteAverage;

    public static final String WIDTH_342 = "w342";
    public static final String WIDTH_500 = "w500";
    public static final String KEY_TITLE = "original_title";
    public static final String KEY_POSTER_PATH = "poster_path";
    public static final String KEY_OVERVIEW = "overview";
    public static final String KEY_RATE = "vote_average";
    public static final String KEY_RELEASE_DATE = "release_date";
    public static final String KEY_ID = "id";
    public static final String TABLE_MOVIE = "movies";
    private static final String URL_IMAGE_TMDB_DEFAULT = "http://image.tmdb.org/t/p/";

    public static String[] projection = {
            KEY_ID,
            KEY_TITLE,
            KEY_OVERVIEW,
            KEY_POSTER_PATH,
            KEY_RATE
    };

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param id
     * @param genreIds
     * @param title
     * @param releaseDate
     * @param overview
     * @param posterPath
     * @param originalTitle
     * @param voteAverage
     * @param originalLanguage
     * @param adult
     * @param backdropPath
     * @param voteCount
     * @param video
     * @param popularity
     */
    public Result(String posterPath, Boolean adult, String overview, String releaseDate, List<Integer> genreIds, Integer id, String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity, Integer voteCount, Boolean video, Float voteAverage) {
        super();
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genreIds = genreIds;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }
    public static Result getItemFromCursor(Cursor c) {
        Result item = new Result();
        item.id = c.getInt(c.getColumnIndex(Result.KEY_ID));
        item.title = c.getString(c.getColumnIndex(Result.KEY_TITLE));
        item.overview = c.getString(c.getColumnIndex(Result.KEY_OVERVIEW));
        item.posterPath = c.getString(c.getColumnIndex(Result.KEY_POSTER_PATH));
        item.popularity = c.getDouble(c.getColumnIndex(Result.KEY_RATE));

        return item;
    }
    public String getFullPosterPath(String preferedWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_IMAGE_TMDB_DEFAULT);
        sb.append(preferedWidth);
        sb.append(posterPath);

        return sb.toString();
    }



}

