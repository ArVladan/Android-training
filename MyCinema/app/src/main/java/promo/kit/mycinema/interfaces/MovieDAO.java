package promo.kit.mycinema.interfaces;

import android.database.Cursor;

import java.io.IOException;
import java.util.List;

import promo.kit.mycinema.model.Movie;

/**
 * Created by Влад on 31.01.17.
 */

public interface MovieDAO<M> {
    long save(M m) throws IOException;
    boolean delete(M m);
    M get(Cursor id);
    List<M> getAll();
    void saveAll(List<Movie> movie);
}
