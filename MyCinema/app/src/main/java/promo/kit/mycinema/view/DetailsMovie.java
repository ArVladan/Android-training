package promo.kit.mycinema.view;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import it.sephiroth.android.library.picasso.Picasso;
import promo.kit.mycinema.R;
import promo.kit.mycinema.model.Movie;

/**
 * Created by Влад on 05.01.17.
 */

public class DetailsMovie extends AppCompatActivity {
    Movie movie;
    Context context;
    private Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie_main);
        Bundle b = getIntent().getExtras();
//        ImageView posterId = (ImageView) findViewById(R.id.detailImage);
//       // dbM.get(b.getInt("id"));
//        int g = b.getInt("id");
//        Cursor с = dbM.getDbId(g);
//        movie = dbM.get(c);
//        if (!TextUtils.isEmpty(movie.getFullPosterPath(Movie.WIDTH_500)))
//            Picasso.with(context)
//                    .load(movie.getFullPosterPath(Movie.WIDTH_500))
//                    .placeholder(R.drawable.image_placeholder)
//                    .into(posterId);
//        poster.setImageDrawable(getResources().getDrawable(b.getInt("id")));
//        TextView textYear = (TextView) findViewById(R.id.year);
//        textYear.setText(b.getString("id2"));
//        TextView textGenre = (TextView) findViewById(R.id.genre);
//        textGenre.setText(b.getString("id3"));
//        TextView textTime = (TextView) findViewById(R.id.time);
//        textTime.setText(b.getString("id4"));
//          TextView textDetail = (TextView) findViewById(R.id.anons);
//          textDetail.setText(b.getString("id"));

    }


}
