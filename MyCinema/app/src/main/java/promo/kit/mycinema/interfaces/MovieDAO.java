package promo.kit.mycinema.interfaces;

import android.database.Cursor;

import java.io.IOException;
import java.util.List;

public interface MovieDAO<M> {
    long save(M m) throws IOException;
    boolean delete(M m);
    M get(Cursor id);
    List<M> getAll();
    void saveAll(List<M> movie);


}
