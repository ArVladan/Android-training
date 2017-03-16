package promo.kit.userregistration.presenter;

import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.DataRepository;
import promo.kit.userregistration.model.User;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserPresenters implements MVPUser.PresenterUser {
    MVPUser.ViewUser view;
    MVPUser.ModelUser model;
    private Subscriber subscription;

    public UserPresenters() {
        model = new DataRepository();
    }

    @Override
    public void setUser(MVPUser.ViewUser v) {
        view = v;
    }

    @Override
    public void getList() {
        model.getResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createSubscription());
    }

    private Subscriber createSubscription(){
        if (this.subscription != null)
            return this.subscription;

        this.subscription = new Subscriber<User>() {

            @Override
            public void onNext(User user) {
                UserPresenters.this.view.onResult(user);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                UserPresenters.this.view.onError(e.getLocalizedMessage());
            }
        };

        return this.subscription;
    }

}
