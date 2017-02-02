package promo.kit.mycinema;

import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import promo.kit.mycinema.adapter.MovieAdapter;
import promo.kit.mycinema.db.MovieOpenHelper;
import promo.kit.mycinema.model.Movie;
import promo.kit.mycinema.network.NetData;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private MovieAdapter movieAdapter;
    private RecyclerView mRecyclerView;
   // private List<MovieOld> sMovieList;
    private List<Movie> movieList;
    private GridLayoutManager  vertikalLayout;
    private LinearLayoutManager  horizontLayout;
    private static final String TAG = "MainActivity";

    private int mLayoutPosition;
    // 7
    private MovieOpenHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

     //  createMovieList();
        mContext = getApplicationContext();

        vertikalLayout = new GridLayoutManager(this, 2);
        horizontLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(vertikalLayout);

      //  movieAdapter = new MovieAdapter(sMovieList);
        movieAdapter = new MovieAdapter(movieList);
        mRecyclerView.setAdapter(movieAdapter);

        new NetDateTask().execute();

//        movieAdapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Movie movie) {
//                Intent i = new Intent(MainActivity.this, DetailsMovie.class);
//                i.putExtra("id", movie.getPosterId());
//                i.putExtra("id2", movie.getYear());
//                i.putExtra("id3", movie.getGanre());
//                i.putExtra("id4", movie.getTime());
//                i.putExtra("id5", movie.getDetail());
//
//                startActivity(i);
//            }
//        });
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

//    private void createMovieList() {
//        sMovieList = new ArrayList<>();
//        sMovieList.add(new MovieOld(R.drawable.avatar, "2009", "Фантастика", "2 часа 58 минут", "Джейк Салли - бывший морской пехотинец, прикованный к инвалидному креслу. Несмотря на немощное тело, Джейк в душе по-прежнему остается воином."));
//        sMovieList.add(new MovieOld(R.drawable.blade, "2008", "Мистика", "2 часа 50 минут","Типичный вампирский шуттер - муттер"));
//        sMovieList.add(new MovieOld(R.drawable.hankok, "2015", "Фантастика", "2 часа 40 минут","Кинуха про войнуху"));
//        sMovieList.add(new MovieOld(R.drawable.maya, "2014", "История", "2 часа 30 минут","Исторический экшин и так далее"));
//        sMovieList.add(new MovieOld(R.drawable.neft,  "2016", "Документальный", "2 часа 40 минут","Про пуйло и его бабло"));
//        sMovieList.add(new MovieOld(R.drawable.sparta,  "2015", "Боевик", "2 часа 35 минут","Кинуха про войнуху в спарте"));
//        sMovieList.add(new MovieOld(R.drawable.star,  "2016", "Фантастика", "2 часа 40 минут","Продолжение саги Звездные войны"));

//    }

    class NetDateTask extends AsyncTask<Void, Void, List<Movie>> {

        @Override
        protected List<Movie> doInBackground(Void... params) {
            return new NetData().fetchItems();
        }

        @Override
        protected void onPostExecute(List<Movie> movieMovies) {
            super.onPostExecute(movieMovies);
            // not null
            // update ui
        }
    }
    // For control create DB
    private void displayDataInfo() {
        SQLiteDatabase db = mHelper.getReadableDatabase();


    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
