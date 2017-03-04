package promo.kit.todojurnal.presenter;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import promo.kit.todojurnal.interfaces.MPVtoDo;
import promo.kit.todojurnal.model.DataRepository;
import promo.kit.todojurnal.model.ModelData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ToDoPresenter implements MPVtoDo.PresenterToDo {
    MPVtoDo.ViewToDo view;
    MPVtoDo.ModelToDo model;
    private Subscription subscription;

    public ToDoPresenter() {
        model = new DataRepository();
    }

    @Override
    public void setToDo(MPVtoDo.ViewToDo v) {
        view = v;
    }

    @Override
    public void getList() {
        model.getToDoList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createSubscription());
    }
    private Subscriber createSubscription(){
        if (this.subscription == null)
            this.subscription = new Subscriber<List<ModelData>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    ToDoPresenter.this.view.onError(e.getLocalizedMessage());
                }

                @Override
                public void onNext(List<ModelData> modelData) {
                    ToDoPresenter.this.view.onResult( modelData);

                }

            };

        return (Subscriber) this.subscription;
    }
}
