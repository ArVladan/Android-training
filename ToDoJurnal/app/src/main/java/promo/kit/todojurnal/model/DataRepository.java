package promo.kit.todojurnal.model;

import android.content.Context;

import promo.kit.todojurnal.interfaces.IRetrofit;
import promo.kit.todojurnal.interfaces.MPVtoDo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepository implements MPVtoDo.ModelToDo {
    private static final String URL_REST = "https://jsonplaceholder.typicode.com/";
    private static IRetrofit inRetrofit;
    private Retrofit retrofit;

    private final Context context;


    public DataRepository(Context context) {
        this.context = context;
    }


    @Override
    public IRetrofit fetchData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        inRetrofit = retrofit.create(IRetrofit.class);
        return inRetrofit;

    }
}
