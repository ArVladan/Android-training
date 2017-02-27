
package promo.kit.mycinema.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import promo.kit.mycinema.R;
import promo.kit.mycinema.interfaces.MVPMovie;
import promo.kit.mycinema.model.Movie;
import promo.kit.mycinema.view.adapter.MovieAdapter;
import promo.kit.mycinema.presenter.MoviePresent;


public class MainActivityFragment extends Fragment
        implements MVPMovie.MoviesView {
    public static final String FRAGMENT = "promo.kit.mycinema.view.MainActivityFragment";
    private List<Movie> movies;
    private MovieAdapter adapter;
    private MVPMovie.MoviesPresenter presenter;
    private GridLayoutManager  vertikalLayout;
    private LinearLayoutManager  horizontLayout;
    private Context context;

    @BindView(R.id.recyclerView)
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        initUI(root);
        presenter = new MoviePresent(getContext());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.setView(this);
        presenter.getMovies();
    }

    private void initUI(View root) {
        movies = new ArrayList<>();
        ButterKnife.bind(this, root);

        adapter = new MovieAdapter(getContext(), movies);
        rv.setAdapter(adapter);

        vertikalLayout = new GridLayoutManager(context, 2);
        horizontLayout = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(vertikalLayout);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.setLayoutManager(horizontLayout);
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            rv.setLayoutManager(vertikalLayout);
        }
    }

    @Override
    public void onMoviesReceived(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), "Error:"+error,
                Toast.LENGTH_SHORT).show();
    }
}