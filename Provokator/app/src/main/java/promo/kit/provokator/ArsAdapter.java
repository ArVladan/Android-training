package promo.kit.provokator;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import promo.kit.provokator.model.Arsenal;

/**
 * Created by Влад on 05.01.17.
 */
public class ArsAdapter extends RecyclerView.Adapter<ArsAdapter.ArsHolder>{
    public List<Arsenal> mArsenalList;
    public ArsAdapter(List<Arsenal> arsenals) {
        mArsenalList = arsenals;
    }


    @Override
    public ArsAdapter.ArsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.arsenal_item, parent, false);
        return new ArsHolder(view);
    }

    @Override
    public void onBindViewHolder(ArsAdapter.ArsHolder holder, int position) {
        Arsenal arsenal = mArsenalList.get(position);
        holder.bindArsenal(arsenal);

    }

    @Override
    public int getItemCount() {
        return mArsenalList.size();
    }
    public class ArsHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private Arsenal mArsenal;

        public ArsHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.imageArsenal);
        }
        public void bindArsenal(Arsenal arsenal) {
            mArsenal = arsenal;
            mIcon.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), mArsenal.getIconId()));
        }
    }
}
