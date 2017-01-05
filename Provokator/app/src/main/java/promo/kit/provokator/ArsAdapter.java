package promo.kit.provokator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import promo.kit.provokator.model.Arsenal;

/**
 * Created by Влад on 05.01.17.
 */
public class ArsAdapter extends RecyclerView.Adapter<ArsAdapter.ArsHolder>{
    private List<Arsenal> mArsenals;
    public ArsAdapter(List<Arsenal> arsenals) {
        mArsenals = arsenals;
    }


    @Override
    public ArsAdapter.ArsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ArsAdapter.ArsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mArsenals.size();
    }
    public class ArsHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private Arsenal mArsenal;

        public ArsHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
        public void bindArsenal(Arsenal arsenal) {
            mArsenal = arsenal;
            mIcon = 
        }
    }
}
