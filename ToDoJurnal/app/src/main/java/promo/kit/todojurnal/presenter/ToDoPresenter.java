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

public class ToDoPresenter implements MPVtoDo.PresenterToDo {
    MPVtoDo.ViewToDo view;
    MPVtoDo.ModelToDo model;

    public ToDoPresenter(Context context) {
        model = new DataRepository(context);
    }

    @Override
    public void setToDo(MPVtoDo.ViewToDo v) {
        view = v;

    }

    @Override
    public void getList() {
        model.fetchData().getData().enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {

                response.body();
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {

            }
        });


    }
}
