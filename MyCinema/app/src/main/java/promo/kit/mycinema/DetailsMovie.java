package promo.kit.mycinema;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Влад on 05.01.17.
 */

public class DetailsMovie extends AppCompatActivity {
    private List<Movie> sMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie_main);
        Intent i = getIntent();
        Movie movie = (Movie) i.getSerializableExtra("desc");
        ImageView poster = (ImageView) findViewById(R.id.detailImage);
        poster.setImageBitmap(BitmapFactory.decodeResource(poster.getResources(), movie.getPosterId()));
        TextView textYear = (TextView) findViewById(R.id.year);
        textYear.setText(movie.getYear());
        TextView textGenre = (TextView) findViewById(R.id.genre);
        textGenre.setText(movie.getGanre());
        TextView textTime = (TextView) findViewById(R.id.time);
        textTime.setText(movie.getTime());
        TextView textDetail = (TextView) findViewById(R.id.anons);
        textDetail.setText(movie.getDetail());


    }
}
