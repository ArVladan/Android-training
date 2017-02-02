package promo.kit.mycinema.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import promo.kit.mycinema.R;
import promo.kit.mycinema.model.Movie;

/**
 * Created by Влад on 31.12.16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    //    private List<MovieOld> movieList;
    private List<Movie> movieList;

    //    public MovieAdapter(List<MovieOld> movies) {
//        movieList = movies;
//    }
    public MovieAdapter(List<Movie> movies) {
        movieList = movies;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bindFilm(movie);
    }

    public static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImage;
        private TextView yaerMovie;
        private TextView genreMovie;
        private Movie mMovie;

        public MovieHolder(final View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.imageView);
            yaerMovie = (TextView) itemView.findViewById(R.id.yearMovie);
            genreMovie = (TextView) itemView.findViewById(R.id.genreMovie);
            itemView.setOnClickListener(this);

        }


        public void bindFilm(Movie item) {
            mMovie = item;
            yaerMovie.setText(mMovie.getReleaseDate());
            genreMovie.setText((int) mMovie.getPopularity());

            //       mImage.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), mMovie.getPosterId()));
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(mMovie);
        }

//        public void
    }


}
