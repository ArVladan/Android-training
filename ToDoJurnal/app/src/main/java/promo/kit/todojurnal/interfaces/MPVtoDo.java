package promo.kit.todojurnal.interfaces;

import java.util.List;

import promo.kit.todojurnal.model.ModelData;

public interface MPVtoDo {
    public interface ViewToDo {
        public void onResult(List<ModelData> list);
        public void onError(String e);

    }
    public interface PresenterToDo {
        public void setToDo(ViewToDo v);
        public void getList();

    }
    public interface ModelToDo {
        public void fetchData();
    }
}
