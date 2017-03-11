package promo.kit.userregistration.model.data;

import java.util.List;

import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.interfaces.RetroUser;
import promo.kit.userregistration.model.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class DataRepository implements MVPUser.ModelUser{
    private static final String URL_REST = "https://randomuser.me/";
    private static RetroUser inRetrofit;
    private Retrofit retrofit;

    public DataRepository() {
        inRetrofit = createIRetrofit();
    }

    private RetroUser createIRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_REST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        inRetrofit = retrofit.create(RetroUser.class);
        return inRetrofit;
    }


    @Override
    public Observable<List<User>> getUsers() {
        return inRetrofit.getUsers();
    }
}

