package promo.kit.testapp.interfaces;


import java.util.List;

import promo.kit.testapp.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitToDoAPI {
    @GET("/todos")
    Call<List<Result>> getToDo();
}
