package promo.kit.testapp.data;

import android.content.Context;

import java.util.List;
import java.util.MissingResourceException;

import promo.kit.testapp.data.utils.NetUtils;
import promo.kit.testapp.interfaces.IListener;
import promo.kit.testapp.interfaces.MVPtoDo;
import promo.kit.testapp.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository  implements MVPtoDo.ToDoModel {
    private Context context;
    private final NetworkRepository rest;

    public DataRepository(Context context) {
        this.context = context;
        rest = new NetworkRepository(context);
    }


    @Override
    public void toDoFetcher(final IListener result) {
        if(!NetUtils.isNetworkAvailable(context)) {
            result.onError(new MissingResourceException("", "", ""));
        } else {
            rest.getResultApi.getToDo().enqueue(new Callback<List<Result>>() {
            @Override
                public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                result.addAll(response.body());

            }

            @Override
                public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });

        }

    }
}
