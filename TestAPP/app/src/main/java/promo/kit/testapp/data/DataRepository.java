package promo.kit.testapp.data;

import android.content.Context;

import promo.kit.testapp.interfaces.IListener;
import promo.kit.testapp.interfaces.MVPtoDo;

public class DataRepository  implements MVPtoDo.ToDoModel {
    private Context context;
    private final NetworkRepository rest;

    public DataRepository(Context context) {
        this.context = context;
        rest = new NetworkRepository(context);
    }


    @Override
    public void toDoFetcher(IListener result) {

    }
}
