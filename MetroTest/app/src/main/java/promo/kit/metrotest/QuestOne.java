package promo.kit.metrotest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuestOne extends Fragment {

    private int sInt;
    private String sString;

    public static QuestOne newInstance(int sInt, String sString) {
        QuestOne tabFrag = new QuestOne();
        Bundle arg = new Bundle();
        arg.putInt("sInt", sInt);
        arg.putString("sString", sString);
        tabFrag.setArguments(arg);
        return tabFrag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sInt = this.getArguments().getInt("sInt");
        String sString = this.getArguments().getString("sString");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        TextView outText;

        outText = (TextView) rootView.findViewById(R.id.answer_1);
        outText.setMovementMethod(new ScrollingMovementMethod());

        TextView bilet = (TextView) rootView.findViewById(R.id.section_1);

        bilet.setText(sString + sInt);



        return rootView;
    }

}
