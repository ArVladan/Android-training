package promo.kit.metrotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import promo.kit.metrotest.model.ModelItem;

public class DatabaseHelper extends SQLiteOpenHelper {

    // путь к базе данных вашего приложения
    private static String DB_PATH = "/data/data/promo.kit.metrotest/databases/";
    public static final String DB_NAME = "answer_db";
    public static final String TABL_NAME = "answer_db";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ANSWER_1 = "answer_1";
    public static final String COLUMN_ANSWER_2 = "answer_2";
    public static final String COLUMN_ANSWER_3 = "answer_3";
    public static final String COLUMN_ANSWER_4 = "answer_4";
    public static final String COLUMN_ANSWER_5 = "answer_5";
    public static final String COLUMN_ANSWER_6 = "answer_6";
    public static final String COLUMN_ANSWER_7 = "answer_7";
    public static final String COLUMN_ANSWER_8 = "answer_8";
    private static final int SCHEMA = 2;
    private final Context context;

    public SQLiteDatabase dbAnswer;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void create_db(){
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH + DB_NAME);
            if (!file.exists()) {
                this.getReadableDatabase();

                myInput = context.getAssets().open(DB_NAME);

                String outFileName = DB_PATH + DB_NAME;

                myOutput = new FileOutputStream(outFileName);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch(IOException ex){

        }
    }
    public void open() throws SQLException {
        String path = DB_PATH + DB_NAME;
        dbAnswer = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (dbAnswer != null) {
            dbAnswer.close();
        }
        super.close();
    }
}