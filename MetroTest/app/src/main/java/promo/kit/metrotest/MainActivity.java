package promo.kit.metrotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import promo.kit.metrotest.adapter.TicketAdapter;
import promo.kit.metrotest.model.ModelItem;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutMenager;
    private TicketAdapter adapter;
    private List<ModelItem> listTicket;

    @BindView(R.id.recicler)
    RecyclerView recylerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        createTicket();
        ButterKnife.bind(this);

        linearLayoutMenager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(linearLayoutMenager);

        adapter = new TicketAdapter(listTicket);
        recylerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new TicketAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ModelItem model) {
                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                i.putExtra("id", model.getBilet());
                i.putExtra("id2", model.getNumber());

                startActivity(i);
            }
        });

    }
    public void createTicket() {
        listTicket = new ArrayList<ModelItem>();
        for(int i = 0; i < 20; i++) {
            listTicket.add(new ModelItem("Билет №", ++i));
            i--;

        }
    }

}
