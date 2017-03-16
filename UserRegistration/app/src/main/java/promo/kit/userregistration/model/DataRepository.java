package promo.kit.userregistration.model;

import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.interfaces.RetroUser;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class DataRepository implements MVPUser.ModelUser{
    private static final String URL_REST = "https://randomuser.me/";
    private static RetroUser retroUser;
    private Retrofit retrofit;

    public DataRepository() {
        retroUser = createIRetrofit();
    }

    private RetroUser createIRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_REST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retroUser = retrofit.create(RetroUser.class);
        return retroUser;
    }

    @Override
    public Observable<User> getResult() {
        return retroUser.getData();
    }
}

