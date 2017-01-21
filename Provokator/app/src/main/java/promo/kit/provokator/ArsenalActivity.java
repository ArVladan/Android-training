package promo.kit.provokator;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import promo.kit.provokator.model.Arsenal;

/**
 * Created by Влад on 05.01.17.
 */

public class ArsenalActivity extends AppCompatActivity {
    private Context mContext;
    private ArsAdapter mArsAdapter;
    private RecyclerView mRecyclerView;
    private List<Arsenal> mArsenalList;
    private GridLayoutManager  vertikalLayout;
    private GridLayoutManager  horizontLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arsenal);

        mContext = getApplicationContext();

        createArsenalList();

        vertikalLayout = new GridLayoutManager(this, 2);
        horizontLayout = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(vertikalLayout);

        mArsAdapter = new ArsAdapter(mArsenalList);
        mRecyclerView.setAdapter(mArsAdapter);

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mRecyclerView.setLayoutManager(horizontLayout);
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(vertikalLayout);
        }
    }
    private void createArsenalList() {
        mArsenalList = new ArrayList<>();
        mArsenalList.add(new Arsenal(R.drawable.rod));
        mArsenalList.add(new Arsenal(R.drawable.bait));
        mArsenalList.add(new Arsenal(R.drawable.feed));
        mArsenalList.add(new Arsenal(R.drawable.feeder));
        mArsenalList.add(new Arsenal(R.drawable.sinker));
        mArsenalList.add(new Arsenal(R.drawable.ic_float));
        mArsenalList.add(new Arsenal(R.drawable.hooks));
        mArsenalList.add(new Arsenal(R.drawable.accessories));
        mArsenalList.add(new Arsenal(R.drawable.category));


    }

}
