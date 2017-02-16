package promo.kit.mycinema.interfaces;

import java.io.IOException;
import java.util.List;


import promo.kit.mycinema.model.Result;

public interface MovieDAO<M> {
    long save(M m) throws IOException;
    boolean delete(M m);
    M get(int id);
    List<M> getAll();
    void saveAll(List<M> movie);


}
