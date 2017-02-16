package promo.kit.mycinema.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import promo.kit.mycinema.interfaces.MovieDAO;

import promo.kit.mycinema.model.Result;


public class DbManager implements MovieDAO<Result> {

    private static final String LOG_TAG = DbManager.class.getSimpleName();
    private MovieOpenHelper dbHalper;

    public DbManager(Context context) {
        dbHalper = new MovieOpenHelper(context);
    }

    @Override
    public long save(Result movie) throws IOException {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Result.KEY_TITLE, movie.title);
        cv.put(Result.KEY_ID, movie.id);
        cv.put(Result.KEY_OVERVIEW, movie.overview);
        cv.put(Result.KEY_POSTER_PATH, movie.posterPath);
        cv.put(Result.KEY_RATE, movie.popularity);
        cv.put(Result.KEY_RELEASE_DATE, movie.releaseDate);

        long _id = db.insert(Result.TABLE_MOVIE, null, cv);
        db.close();
        return  _id;

    }

    @Override
    public boolean delete(Result movie) {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        String[] whereArgs = {String.valueOf(movie.id)};
        int rows = db.delete(Result.TABLE_MOVIE, Result.KEY_ID,
                whereArgs);
        db.close();

        return rows > 0;
    }

    @Override
    public Result get(int id) {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};
        Cursor c = db.query(Result.TABLE_MOVIE,
                Result.projection,
                Result.KEY_ID + " = ? ",
                whereArgs,
                null,
                null,
                null);

        Result item = null;
        while (c != null && c.moveToFirst()) {
            item = Result.getItemFromCursor(c);
        }

        return item;
    }

    @Override
    public List<Result> getAll() {
        SQLiteDatabase db = dbHalper.getWritableDatabase();
        Cursor c = db.query(Result.TABLE_MOVIE,
                Result.projection,
                null,
                null,
                null,
                null,
                null);

        if (c == null)
            return null;

        List<Result> items = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Result item = Result.getItemFromCursor(c);
                items.add(item);
            } while (c.moveToNext());
        }

        c.close();

        return items;
    }

    @Override
    public void saveAll(List<Result> movies) { SQLiteDatabase db = dbHalper.getWritableDatabase();

        for (Result movie: movies) {
            ContentValues cv = new ContentValues();
            cv.put(Result.KEY_TITLE, movie.title);
            cv.put(Result.KEY_OVERVIEW, movie.overview);
            cv.put(Result.KEY_RATE, movie.popularity);
            cv.put(Result.KEY_POSTER_PATH, movie.posterPath);
            long id = db.insert(Result.TABLE_MOVIE, null, cv);
            Log.d(LOG_TAG, "Inserted id=" + id);
        }

        db.close();


    }



}
