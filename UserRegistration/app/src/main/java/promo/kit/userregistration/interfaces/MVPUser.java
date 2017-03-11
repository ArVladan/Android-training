package promo.kit.userregistration.interfaces;

import java.util.List;


import promo.kit.userregistration.model.Result;
import rx.Observable;

public interface MVPUser {
    public interface ViewUser {
        public void onResult(List<Result> list);
        public void onError(String e);
    }

    public interface PresenterUser {
        public void setUser(ViewUser v);
        public void getList();
    }

    public interface ModelUser {
        Observable<List<Result>> getResult();
    }

}
