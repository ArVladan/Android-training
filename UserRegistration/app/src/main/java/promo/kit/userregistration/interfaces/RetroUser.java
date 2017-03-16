package promo.kit.userregistration.interfaces;


import promo.kit.userregistration.model.User;
import retrofit2.http.GET;
import rx.Observable;

public interface RetroUser {
    @GET("api")
    Observable<User> getData();
}