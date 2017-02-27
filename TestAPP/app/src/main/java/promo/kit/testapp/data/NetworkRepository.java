package promo.kit.testapp.data;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import promo.kit.testapp.interfaces.IListener;
import promo.kit.testapp.interfaces.MVPtoDo;
import promo.kit.testapp.interfaces.RetrofitToDoAPI;
import promo.kit.testapp.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class NetworkRepository {
    private Context context;
    private Retrofit client;
    private static RetrofitToDoAPI interRetrofit;


    public NetworkRepository(Context context) {
        this.context = this.context;
    }

    public void getRetroApi() {
        String API_BASE_URL = "https://jsonplaceholder.typicode.com/";

        client = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        interRetrofit = client.create(RetrofitToDoAPI.class);
    }

    public static RetrofitToDoAPI getApi() {
        return  interRetrofit;

    }

//    NetworkRepository.getApi().getToDo().enqueue(new Callback<List<Result>>() {
//        @Override
//        public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
//            result.addAll(response.body());
//
//        }
//
//        @Override
//        public void onFailure(Call<List<Result>> call, Throwable t) {
//
//        }
//    });
}

