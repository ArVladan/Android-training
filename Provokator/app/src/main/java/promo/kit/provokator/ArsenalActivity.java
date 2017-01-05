package promo.kit.provokator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private List<Arsenal> sArsenalList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main);
    }
    private void createArsenalList() {
        sArsenalList = new ArrayList<>();
        sArsenalList.add(new Arsenal(R.drawable.rod));
        sArsenalList.add(new Arsenal(R.drawable.bait));
        sArsenalList.add(new Arsenal(R.drawable.feed));
        sArsenalList.add(new Arsenal(R.drawable.feeder));
        sArsenalList.add(new Arsenal(R.drawable.hooks));
        sArsenalList.add(new Arsenal(R.drawable.ic_float));
        sArsenalList.add(new Arsenal(R.drawable.accessories));
        sArsenalList.add(new Arsenal(R.drawable.category));


    }

}
