package promo.kit.todojurnal;

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
import promo.kit.todojurnal.interfaces.MPVtoDo;
import promo.kit.todojurnal.model.ModelData;
import promo.kit.todojurnal.presenter.ToDoPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFragment extends Fragment implements MPVtoDo.ViewToDo {
    private LinearLayoutManager layout;
    private Context context;
    private TodoAdapter adapter;
    private List<ModelData> list;
    private MPVtoDo.PresenterToDo presenter;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);



        createUI (root);
        presenter = new ToDoPresenter(getContext());
//        fetchResult();
        return root;

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setToDo(this);
        presenter.getList();
    }

    private void createUI (View root) {
        list = new ArrayList<ModelData>();
        ButterKnife.bind(this, root);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TodoAdapter(list);
        recyclerView.setAdapter(adapter);
    }

//    public void fetchResult() {
//        App.getApi().getData().enqueue(new Callback<List<ModelData>>() {
//            @Override
//            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
//                list.addAll(response.body());
//                recyclerView.getAdapter().notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<List<ModelData>> call, Throwable t) {
//                Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


    @Override
    public void onResult(List<ModelData> list) {
        this.list.clear();
        this.list.addAll(list);
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void onError(String e) {
        Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }
}
