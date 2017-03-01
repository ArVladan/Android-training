package promo.kit.testapp.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import promo.kit.testapp.R;
import promo.kit.testapp.interfaces.MVPtoDo;
import promo.kit.testapp.model.Result;
import promo.kit.testapp.view.adapter.ToDoAdapter;
import promo.kit.testapp.presenter.ToDoPresenter;


public class MainActivityFragment extends Fragment  implements MVPtoDo.ToDoView {

    private List<Result> results;
    private ToDoAdapter adapter;
    private MVPtoDo.ToDoPresenter presenter;
    private LinearLayoutManager vertikalLayout;
    private Context context;

    @BindView(R.id.recicler)
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        initUI(root);
        presenter = new ToDoPresenter(getContext());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.setView(this);
        presenter.getResultToDo();
    }

    private void initUI(View root) {
        results = new ArrayList<>();
        ButterKnife.bind(this, root);

        adapter = new ToDoAdapter(getContext(), results);
        rv.setAdapter(adapter);

        vertikalLayout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(vertikalLayout);

    }

    @Override
    public void onTextToDo(List<Result> result) {
        this.results.clear();
        this.results.addAll(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), "Error:" + error,
                Toast.LENGTH_SHORT).show();
    }
}