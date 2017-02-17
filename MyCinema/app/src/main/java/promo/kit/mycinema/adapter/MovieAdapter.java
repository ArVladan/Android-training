package promo.kit.mycinema.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;
import promo.kit.mycinema.R;

import promo.kit.mycinema.model.Movie;

import static promo.kit.mycinema.R.layout.item;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    //    private List<MovieOld> movies;
    private List<Movie> movies;
    private Context context;

    public  MovieAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie movie = movies.get(position);
        if (!TextUtils.isEmpty(movie.getFullPosterPath(Movie.WIDTH_500)))
            Picasso.with(context)
                    .load(movie.getFullPosterPath(Movie.WIDTH_500))
                    .placeholder(R.drawable.image_placeholder)
                    .into(holder.poster);
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
        private ImageView poster;
        private TextView releeseData;
        private TextView popularity;
        private Movie mMovie;


        public MovieHolder(final View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.imageView);
            releeseData = (TextView) itemView.findViewById(R.id.releese_data);
            popularity = (TextView) itemView.findViewById(R.id.genreMovie);
            itemView.setOnClickListener(this);
        }

        public void bindFilm(Movie item) {
            mMovie = item;
            releeseData.setText(mMovie.getReleaseDate());
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(mMovie);
        }

    }


}
