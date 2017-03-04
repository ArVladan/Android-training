package promo.kit.todojurnal.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import promo.kit.todojurnal.R;
import promo.kit.todojurnal.model.ModelData;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder>{
    private List<ModelData> list;

    public TodoAdapter(List<ModelData> list) {
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelData model = list.get(position);
        holder.bind(model);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ModelData model;
        @BindView(R.id.data)
        TextView dataText;
        @BindView(R.id.id)
        TextView idText;
        @BindView(R.id.title)
        TextView titleText;
        @BindView(R.id.completed)
        TextView comText;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        public void bind(ModelData model) {
            this.model = model;
            titleText.setText(model.getTitle());
            dataText.setText(Integer.toString(model.getUserId()));
            idText.setText(String.valueOf(model.getId()));
            comText.setText(Boolean.toString(model.isCompleted()));

        }
    }

}