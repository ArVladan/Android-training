package promo.kit.userregistration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import promo.kit.userregistration.R;
import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.Name;
import promo.kit.userregistration.model.Picture;
import promo.kit.userregistration.model.Result;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  {
    public List<Result> results;
    public Result user;

    private MVPUser.PresenterUser presenter;
    private Context context;
    public String name;
    public String picture;
    Name n;
    Picture p;
    RecyclerView rv;
    UserAdapter adapter;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle b = getActivity().getIntent().getExtras();

        if (b != null) {
            String nik = b.getString("id");
            n = new Name();
            n.setFirst(nik);
            Picture p = new Picture();
            p.setThumbnail(b.getString("icon"));
            user = new Result(n, p);

            createUser();

            rv = (RecyclerView) root.findViewById(R.id.recycler);

            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            rv.setLayoutManager(layoutManager);

            adapter = new UserAdapter(results, getContext());
            rv.setAdapter(adapter);
            rv.getAdapter().notifyDataSetChanged();
        }
        ButterKnife.bind(this, root);

        return root;
    }

    private void createUser () {
        results = new ArrayList<>();
        results.add(user);
    }

    @OnClick(R.id.fab)
    public void performSend(View view) {
        Intent i = new Intent(getActivity(), AddNewUser.class);
        startActivity(i);
    }

}
