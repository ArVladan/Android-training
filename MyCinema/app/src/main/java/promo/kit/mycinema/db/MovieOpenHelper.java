package promo.kit.mycinema.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import promo.kit.mycinema.model.Result;


public class MovieOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movie_db";
    private static final int DB_VERSION = 6;

    public MovieOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Result.TABLE_MOVIE + " (" +
                Result.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Result.KEY_TITLE + " TEXT, " +
                Result.KEY_OVERVIEW + " TEXT, " +
                Result.KEY_POSTER_PATH + " TEXT, " +
                Result.KEY_RATE + " INT, " +
                Result.KEY_RELEASE_DATE + " TEXT " +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + Result.TABLE_MOVIE);
        onCreate(db);
    }
}
