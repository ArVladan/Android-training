//package promo.kit.userregistration.view;
//
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import it.sephiroth.android.library.picasso.Picasso;
//import promo.kit.userregistration.R;
//import promo.kit.userregistration.model.Result;
//
//import static promo.kit.userregistration.R.layout.item_add;
//
//public class AddAdapter extends RecyclerView.Adapter<AddAdapter.AddHolder> {
//
//    private List<Result> res;
//    private Context context;
//
//    public  AddAdapter(List<Result> user, Context context) {
//        this.context = context;
//        res = user;
//    }
//
//    @Override
//    public AddHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(item_add, parent, false);
//        return new AddHolder(view);
//    }
//
//    @Override
//    public int getItemCount() {
//        return res == null ? 0 : res.size();
//    }
//
//    @Override
//    public void onBindViewHolder(AddHolder holder, int position) {
//        Result result = res.get(position);
//        String image = result.getPicture().getLarge();
//        if (!TextUtils.isEmpty(image))
//            Picasso.with(context)
//                    .load(image)
//                    .placeholder(R.drawable.image_placeholder)
//                    .into(holder.poster);
//        holder.bindUser(result);
//    }
//
//
//    public class AddHolder extends RecyclerView.ViewHolder {
//        private Result result;
//
//        @BindView(R.id.portrait)
//        ImageView poster;
//        @BindView(R.id.name_id)
//        TextView name;
//        @BindView(R.id.password_id)
//        TextView pass;
//        @BindView(R.id.mail_id)
//        TextView mail;
//        @BindView(R.id.login_id)
//        TextView login;
//
//        public AddHolder(final View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//
//        public void bindUser(Result res) {
//            result = res;
//            name.setText(result.getName().getFirst() + " " + result.getName().getLast());
//            mail.setText(result.getEmail());
//            login.setText(result.getLogin().getUsername());
//            pass.setText(result.getLogin().getPassword());
//        }
//    }
//
//}
