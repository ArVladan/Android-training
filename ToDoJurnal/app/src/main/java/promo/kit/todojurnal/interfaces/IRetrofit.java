package promo.kit.todojurnal.interfaces;


import java.util.List;
import java.util.Observable;

import promo.kit.todojurnal.model.ModelData;
import retrofit2.http.GET;


public interface IRetrofit {
    @GET("todos")
    rx.Observable<List<ModelData>> getData();
}
