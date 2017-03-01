package promo.kit.testapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import promo.kit.testapp.R;
import promo.kit.testapp.model.Result;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{
    private List<Result> result;

    private Context context;

    public  ToDoAdapter(Context context, List<Result> results) {
        this.result = results;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result model = result.get(position);
        holder.bind(model);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user)
        public TextView user;
        @BindView(R.id.id)
        public TextView id;
        @BindView(R.id.title)
        public TextView title;
        @BindView(R.id.completed)
        public TextView completed;
        private Result result;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(view);
        }

        public void bind(Result model) {
            result = model;
            user.setText(Integer.toString(result.getUserId()));
            id.setText(Integer.toString(result.getId()));
            title.setText(result.getTitle());
            completed.setText(Boolean.toString(result.getCompleted()));


//            Other variants intenger converted
//            number_bilet.setText(String.valueOf(mModelItem.getNumber()));
//            number_bilet.setText(Integer.toString(mModelItem.getNumber()));

        }
    }
}
