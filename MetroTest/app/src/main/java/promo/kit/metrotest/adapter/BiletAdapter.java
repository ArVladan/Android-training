package promo.kit.metrotest.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import promo.kit.metrotest.R;
import promo.kit.metrotest.model.ModelItem;


public class BiletAdapter extends RecyclerView.Adapter<BiletAdapter.ViewHolder>{
    private List<ModelItem> bilet;

    public BiletAdapter(List<ModelItem> listBilet) {
        bilet = listBilet;
    }

//    public void addAll(List<ModelItem> fakeItems) {
//        int pos = getItemCount();
//        this.bilet.addAll(fakeItems);
//        notifyItemRangeInserted(pos, this.bilet.size());
//    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return bilet.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelItem model = bilet.get(position);
        holder.bind(model);
    }

    public static OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(ModelItem model);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bilet_text;
        private TextView number_bilet;
        private ModelItem mModelItem;


        public ViewHolder(View itemView) {
            super(itemView);
            bilet_text = (TextView) itemView.findViewById(R.id.bilet);
            number_bilet = (TextView) itemView.findViewById(R.id.number);
            itemView.setOnClickListener(this);
        }

        public void bind(ModelItem modelItem) {
            mModelItem = modelItem;
            bilet_text.setText(mModelItem.getBilet());
            number_bilet.setText("" + (mModelItem.getNumber()));

//            Other variants intenger converted
//            number_bilet.setText(String.valueOf(mModelItem.getNumber()));
//            number_bilet.setText(Integer.toString(mModelItem.getNumber()));
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(mModelItem);
        }
    }

}
