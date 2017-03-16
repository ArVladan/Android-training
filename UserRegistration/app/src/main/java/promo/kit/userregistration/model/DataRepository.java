package promo.kit.userregistration.model;

import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.interfaces.IRetroUser;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class DataRepository implements MVPUser.ModelUser{
    private static final String URL_REST = "https://randomuser.me/";
    private static IRetroUser sIRetroUser;
    private Retrofit retrofit;

    public DataRepository() {
        sIRetroUser = createIRetrofit();
    }

    private IRetroUser createIRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_REST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        sIRetroUser = retrofit.create(IRetroUser.class);
        return sIRetroUser;
    }

    @Override
    public Observable<User> getResult() {
        return sIRetroUser.getData();
    }
}

