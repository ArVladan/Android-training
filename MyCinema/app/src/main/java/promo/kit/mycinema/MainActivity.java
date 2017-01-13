package promo.kit.mycinema;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private FilmAdapter mFilmAdapter;
    private RecyclerView mRecyclerView;
    private List<Movie> sMovieList;
    private GridLayoutManager  vertikalLayout;
    private LinearLayoutManager  horizontLayout;

    private int mLayoutPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);


        createMovieList();
        mContext = getApplicationContext();


        vertikalLayout = new GridLayoutManager(this, 2);
        horizontLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(vertikalLayout);

        mFilmAdapter = new FilmAdapter(sMovieList);
        mRecyclerView.setAdapter(mFilmAdapter);

        mFilmAdapter.setOnItemClickListener(new FilmAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(MainActivity.this, DetailsMovie.class);
                startActivity(intent);
            }
        });
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mRecyclerView.setLayoutManager(horizontLayout);
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(vertikalLayout);
        }
    }

    private void createMovieList() {
        sMovieList = new ArrayList<>();
        sMovieList.add(new Movie(R.drawable.avatar, "2009", "Фантастика", "2 часа 58 минут", "Джейк Салли - бывший морской пехотинец, прикованный к инвалидному креслу. Несмотря на немощное тело, Джейк в душе по-прежнему остается воином."));
        sMovieList.add(new Movie(R.drawable.blade, "2008", "Мистика", "2 часа 50 минут","Типичный вампирский шуттер - муттер"));
        sMovieList.add(new Movie(R.drawable.hankok, "2015", "Фантастика", "2 часа 40 минут","Кинуха про войнуху"));
        sMovieList.add(new Movie(R.drawable.maya, "2014", "История", "2 часа 30 минут","Исторический экшин и так далее"));
        sMovieList.add(new Movie(R.drawable.neft,  "2016", "Документальный", "2 часа 40 минут","Про пуйло и его бабло"));
        sMovieList.add(new Movie(R.drawable.sparta,  "2015", "Боевик", "2 часа 35 минут","Кинуха про войнуху в спарте"));
        sMovieList.add(new Movie(R.drawable.star,  "2016", "Фантастика", "2 часа 40 минут","Продолжение саги Звездные войны"));

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
