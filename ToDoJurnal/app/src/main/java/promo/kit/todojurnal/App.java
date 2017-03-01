package promo.kit.todojurnal;

import android.app.Application;

import promo.kit.todojurnal.interfaces.IRetrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {
    private static final String URL_REST = "https://jsonplaceholder.typicode.com/";
    private static IRetrofit inRetrofit;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        inRetrofit = retrofit.create(IRetrofit.class);
    }

    public static IRetrofit getApi() {
        return inRetrofit;
    }
}