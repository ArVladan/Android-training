package promo.kit.testapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import promo.kit.testapp.data.DataRepository;
import promo.kit.testapp.data.NetworkRepository;
import promo.kit.testapp.interfaces.IListener;
import promo.kit.testapp.interfaces.MVPtoDo;
import promo.kit.testapp.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ToDoPresenter implements MVPtoDo.ToDoPresenter {

    private MVPtoDo.ToDoView view;
    private MVPtoDo.ToDoModel model;
    public List<Result> result;

    public ToDoPresenter(Context context) {
        model = new DataRepository(context);
    }

    @Override
    public void setView(MVPtoDo.ToDoView view) {
        this.view = view;
    }

    @Override
    public void getResultToDo() {
        model.toDoFetcher(new IListener() {
            @Override
            public void onResult(List<Result> result) {
                if(ToDoPresenter.this.view != null){
                    ToDoPresenter.this.view.onTextToDo(result);
                }
            }

            @Override
            public void onError(Exception e) {
                if(ToDoPresenter.this.view != null){
                    ToDoPresenter.this.view.onError(e.getLocalizedMessage());
                }
            }
        });

    }


}
