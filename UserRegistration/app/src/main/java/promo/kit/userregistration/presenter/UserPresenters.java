package promo.kit.userregistration.presenter;

import java.util.List;

import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.Result;
import promo.kit.userregistration.model.User;
import promo.kit.userregistration.model.data.DataRepository;
import rx.Subscriber;
import rx.Subscription;
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

        this.subscription = new Subscriber<List<Result>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                UserPresenters.this.view.onError(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<Result> modelData) {
                UserPresenters.this.view.onResult(modelData);
            }
        };

        return this.subscription;
    }

}
