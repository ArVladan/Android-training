package promo.kit.userregistration.interfaces;

import promo.kit.userregistration.model.User;
import rx.Observable;

public interface MVPUser {
    public interface ViewUser {
        public void onResult(User user);
        public void onError(String e);
    }

    public interface PresenterUser {
        public void setUser(ViewUser v);
        public void getList();
    }

    public interface ModelUser {
        Observable<User> getResult();
    }

}
