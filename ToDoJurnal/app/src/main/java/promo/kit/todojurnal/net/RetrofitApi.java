package promo.kit.todojurnal.net;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import promo.kit.todojurnal.interfaces.IRetrofit;
import promo.kit.todojurnal.model.ModelData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    private static IRetrofit inRetrofit;
    private Retrofit rest;
    private Context context;
    private static final String URL_REST = "https://jsonplaceholder.typicode.com/";
    public List<ModelData> toDo;

    public RetrofitApi(Context context) {
        this.context = context;
    }

    public List<ModelData> loadData() {
        Retrofit rest = new Retrofit.Builder()
                .baseUrl(URL_REST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRetrofit inRetrofit = rest.create(IRetrofit.class);
        Call<List<ModelData>> call = inRetrofit.getData();
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                List<ModelData> toDo = new ArrayList<ModelData>();
                toDo = response.body();

            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
            }
        });
        return toDo;
    }



}
