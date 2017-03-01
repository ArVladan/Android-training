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
    private final Context context;

    public NetworkRepository(Context context) {
        this.context = context;
    }

    public RetrofitToDoAPI getRetrofitToDoApi() {
        return RetrofitFetcher.getApi();
    }

}

