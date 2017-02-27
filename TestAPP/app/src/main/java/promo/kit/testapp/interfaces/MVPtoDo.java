package promo.kit.testapp.interfaces;


import java.util.List;

import promo.kit.testapp.model.Result;

public interface MVPtoDo {

    interface ToDoView {

        void onTextToDo(List<Result> results);
        void onError(String error);
    }

    interface ToDoPresenter {

        void setView(ToDoView view);
        void getResultToDo();
    }

    interface ToDoModel {
        void toDoFetcher(IListener result);
    }

}
