package promo.kit.userregistration.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

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
    SharedPreferences preference;
    int count;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle b = getActivity().getIntent().getExtras();

        if (b != null) {
            n = new Name();
            n.setFirst(b.getString("id") + " " + b.getString("last"));
            Picture p = new Picture();
            p.setThumbnail(b.getString("icon"));
            user = new Result(n, p);

            createUser();

            rv = (RecyclerView) root.findViewById(R.id.recycler);
            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            rv.setItemAnimator(itemAnimator);

            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            rv.setLayoutManager(layoutManager);

            preference = getActivity().getSharedPreferences("MAIN_STORAGE", Context.MODE_PRIVATE);

            adapter = new UserAdapter(results, getContext());

//            if(count > 0) {
//                copyItem(--count);
//            }

            rv.setAdapter(adapter);
            rv.getAdapter().notifyDataSetChanged();
        }
        ButterKnife.bind(this, root);
        setRetainInstance(true);

        return root;
    }

    private void createUser () {
        results = new ArrayList<>();
        if(count > 0) {
            results = loadList("user", null);
            results.add(user);
            saveObject("user", user);
        }
        count++;
        results.add(user);
        saveObject("user", user);

    }

    public void saveObject(String key, Result res)
    {
        SharedPreferences.Editor editor = preference.edit();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(res);
        editor.putString(key, jsonStr);
        editor.commit();
    }

    public ArrayList<Result> loadList(String key, Class<Result> class_)
    {

        Gson gson = new Gson();
        ArrayList<Result> arrayList = new ArrayList<>();
        String json = preference.getString(key, "");

        if (TextUtils.isEmpty(json)) return arrayList;

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();

        for(int i = 0; i < array.size(); i++)
        {
            arrayList.add(gson.fromJson(array.get(i), class_));
        }

        return arrayList ;
    }


    private void copyItem(int position){
        //Скопируем элемент с индексом position и вставим копию в следующую позицию
        Result currentUser = results.get(position);
        adapter.addItem(position + 1, currentUser);
        //Известим адаптер о добавлении элемента
        adapter.notifyItemInserted(position + 1);
    }


    @OnClick(R.id.fab)
    public void performSend(View view) {
        Intent i = new Intent(getActivity(), AddNewUser.class);
        startActivity(i);
    }

}
