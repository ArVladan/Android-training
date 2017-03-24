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
import promo.kit.userregistration.model.Result;

import static promo.kit.userregistration.R.layout.item;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<Result> res;
    private Context context;

    public  UserAdapter(List<Result> user, Context context) {
        this.context = context;
        res = user;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public int getItemCount() {
        return res == null ? 0 : res.size();
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        Result result = res.get(position);
        String image = result.getPicture().getThumbnail();
        if (!TextUtils.isEmpty(image))
            Picasso.with(context)
                    .load(image)
                    .placeholder(R.drawable.image_placeholder)
                    .into(holder.poster);
        holder.bindUser(result);
    }

    public void addItem(int position, Result user){
        this.res.add(position, user);
        //Мы можем вызвать
        //super.notifyItemInserted(position);
    }


    public class UserHolder extends RecyclerView.ViewHolder {
        private Result result;

        @BindView(R.id.imageView)
        ImageView poster;
        @BindView(R.id.name)
        TextView name;

        public UserHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindUser(Result res) {
            result = res;
            name.setText(result.getName().getFirst());
        }
    }

}
