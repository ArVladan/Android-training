package promo.kit.testapp.interfaces;


import java.util.List;

import promo.kit.testapp.model.Result;

public interface IListener {
    void onResult(List<Result> result);
    void onError(Exception e);
}
