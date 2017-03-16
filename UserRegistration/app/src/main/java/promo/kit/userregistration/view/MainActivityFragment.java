package promo.kit.userregistration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import promo.kit.userregistration.R;
import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.Result;
import promo.kit.userregistration.model.User;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  {
    public List<Result> results;
    public User user;
    private UserAdapter adapter;
    private MVPUser.PresenterUser presenter;
    private Context context;

    @BindView(R.id.fab)
    FloatingActionButton fab;
//    @BindView(R.id.recycler)
//    RecyclerView rv;

    public static MainActivityFragment newInstance(String name, String adress) {
        MainActivityFragment mainList = new MainActivityFragment();
        Bundle arg = new Bundle();
        arg.putString("id", name);
        arg.putString("icon", adress);
        mainList.setArguments(arg);
        return mainList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
//        presenter = new UserPresenters();
        ButterKnife.bind(this, root);

//        initUI(root);

        return root;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        presenter.setUser(this);
//        presenter.getList();
//    }
//
//    @Override
//    public void onResult(User user) {
//        this.results.clear();
//        this.results.addAll(user.getResults());
//        rv.getAdapter().notifyDataSetChanged();
//
//    }
//
//    private void initUI(View root) {
//        results = new ArrayList<Result>();
//        ButterKnife.bind(this, root);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        rv.setLayoutManager(layoutManager);
//
//        adapter = new UserAdapter(results, getContext());
//        rv.setAdapter(adapter);
//    }

    @OnClick(R.id.fab)
    public void performSend(View view) {
        Intent i = new Intent(getActivity(), AddNewUser.class);
        startActivity(i);
    }

//    @Override
//    public void onError(String e) {
//        Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
//    }

}
