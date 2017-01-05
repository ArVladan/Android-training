package promo.kit.mycinema;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private FilmAdapter mFilmAdapter;
    private RecyclerView mRecyclerView;
    private List<Movie> sMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createMovieList();
        mContext = getApplicationContext();

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new GridLayoutManager(mContext, 2);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);

        mFilmAdapter = new FilmAdapter(sMovieList);
        mRecyclerView.setAdapter(mFilmAdapter);
    }

    private void createMovieList() {
        sMovieList = new ArrayList<>();
        sMovieList.add(new Movie("Avatar", R.drawable.avatar));
        sMovieList.add(new Movie("Blade", R.drawable.blade));
        sMovieList.add(new Movie("Hankok", R.drawable.hankok));
        sMovieList.add(new Movie("Maya", R.drawable.maya));
        sMovieList.add(new Movie("Neft", R.drawable.neft));
        sMovieList.add(new Movie("Sparta", R.drawable.sparta));
        sMovieList.add(new Movie("StarWars", R.drawable.star));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
