package promo.kit.testapp.data;


import promo.kit.testapp.interfaces.RetrofitToDoAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFetcher {
    private Retrofit client;
    private static RetrofitToDoAPI interRetrofit;

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
}
