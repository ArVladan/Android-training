package promo.kit.mycinema.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import promo.kit.mycinema.model.Movie;

public class MovieOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movie_db";
    private static final int DB_VERSION = 6;

    public MovieOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Movie.TABLE_MOVIE + " (" +
                Movie.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Movie.KEY_ID_MOVIE + " INT, " +
                Movie.KEY_TITLE + " TEXT, " +
                Movie.KEY_OVERVIEW + " TEXT, " +
                Movie.KEY_POSTER_PATH + " TEXT, " +
                Movie.KEY_RATE + " INT, " +
                Movie.KEY_RELEASE_DATE + " TEXT " +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + Movie.TABLE_MOVIE);
        onCreate(db);
    }
}
