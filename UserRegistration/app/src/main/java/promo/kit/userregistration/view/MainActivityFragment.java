package promo.kit.userregistration.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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
import butterknife.OnClick;
import promo.kit.userregistration.R;
import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.Result;
import promo.kit.userregistration.model.User;
import promo.kit.userregistration.presenter.UserPresenters;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MVPUser.ViewUser {

    public   List<Result> list;
    private UserAdapter adapter;
    private MVPUser.PresenterUser presenter;
    private Context context;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    @BindView(R.id.recycler)
    RecyclerView rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        initUI(root);

        presenter = new UserPresenters();

        ButterKnife.bind(this, root);
        return root;
    }

    private void initUI(View root) {
        list = new ArrayList<Result>();
        ButterKnife.bind(this, root);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        rv.setLayoutManager(layoutManager);

        adapter = new UserAdapter(list);
        rv.setAdapter(adapter);
    }
    @OnClick(R.id.fab)
    public void performSend(View view) {
        Intent i = new Intent(getActivity(), AddNewUser.class);

        startActivity(i);
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.setUser(this);
        presenter.getList();
    }



    @Override
    public void onResult(List<Result> list) {
        this.list.clear();
        this.list.addAll(list);
        rv.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void onError(String e) {
        Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }
}
