package promo.kit.mycinema.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.List;

import promo.kit.mycinema.interfaces.MovieDAO;
import promo.kit.mycinema.model.Movie;

/**
 * Created by Влад on 31.01.17.
 */

public class DbManager implements MovieDAO<Movie> {

    private static final String LOG_TAG = DbManager.class.getSimpleName();
    private MovieOpenHelper dbHalper;

    public DbManager(Context context) {
        dbHalper = new MovieOpenHelper(context);
    }

    @Override
    public long save(Movie movie) throws IOException {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Movie.KEY_TITLE, movie.title);
        cv.put(Movie.KEY_ID, movie.id);
        cv.put(Movie.KEY_OVERVIEW, movie.overview);
        cv.put(Movie.KEY_POSTER_PATH, movie.posterPath);
        cv.put(Movie.KEY_RATE, movie.popularity);
        cv.put(Movie.KEY_RELEASE_DATE, movie.releaseDate);

        long _id = db.insert(Movie.TABLE_MOVIE, null, cv);
        db.close();
        return  _id;

    }

    @Override
    public boolean delete(Movie movie) {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        String[] whereArgs = {String.valueOf(movie.id)};
        int rows = db.delete(Movie.TABLE_MOVIE, Movie.KEY_ID,
                whereArgs);
        db.close();

        return rows > 0;
    }

    @Override
    public Movie get(int id) {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};
        Cursor c = db.query(Movie.TABLE_MOVIE,
                Movie.projection,
                Movie.KEY_ID + " = ? ",
                whereArgs,
                null,
                null,
                null);

        Movie item = null;
        while (c != null && c.moveToFirst()) {
            item = Movie.getItemFromCursor(c);
        }

        return item;
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public void saveAll(List<Movie> movie) {

    }
}
