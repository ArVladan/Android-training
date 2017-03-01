package promo.kit.todojurnal.interfaces;


import java.util.List;

import promo.kit.todojurnal.model.ModelData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRetrofit {
    @GET("todos")
    Call<List<ModelData>> getData();
}
