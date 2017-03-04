package promo.kit.todojurnal.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import promo.kit.todojurnal.interfaces.IRetrofit;
import promo.kit.todojurnal.interfaces.MPVtoDo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class DataRepository implements MPVtoDo.ModelToDo {
    private static final String URL_REST = "https://jsonplaceholder.typicode.com/";
    private static IRetrofit inRetrofit;
    private Retrofit retrofit;




    public DataRepository() {
        inRetrofit = createIRetrofit();
    }

    private IRetrofit createIRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_REST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        inRetrofit = retrofit.create(IRetrofit.class);
        return inRetrofit;
    }


    @Override
    public Observable<List<ModelData>> getToDoList() {

       return inRetrofit.getData();

    }
}
