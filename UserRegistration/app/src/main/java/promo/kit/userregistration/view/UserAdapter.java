package promo.kit.userregistration.view;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.picasso.Picasso;
import promo.kit.userregistration.R;
import promo.kit.userregistration.model.User;

import static promo.kit.userregistration.R.layout.item;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<User> users;
    private Context context;

    public  UserAdapter(List<User> user) {
        this.users = user;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = users.get(position);
        if (!TextUtils.isEmpty(user.getPhoto(User.WIDTH_50)))
            Picasso.with(context)
                    .load(user.getPhoto(User.WIDTH_50))
                    .placeholder(R.drawable.image_placeholder)
                    .into(holder.poster);
        holder.bindFilm(user);
    }

    public static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(User user);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private User user;

        @BindView(R.id.imageView)
        ImageView poster;
        @BindView(R.id.name)
        TextView name;

        public UserHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
            itemView.setOnClickListener(this);
        }

        public void bindFilm(User item) {
            user = item;
            name.setText(user.getName());
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(user);
        }
    }

}
