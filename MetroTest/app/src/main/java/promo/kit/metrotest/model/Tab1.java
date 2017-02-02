package promo.kit.metrotest.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import promo.kit.metrotest.R;

public class Tab1 extends Fragment {

//    public static Tab1 newInstance(int sInt, String sString) {
//        Tab1 tabFrag = new Tab1();
//        Bundle arg = new Bundle();
//        arg.putInt("sInt", sInt);
//        arg.putString("sString", sString);
//        tabFrag.setArguments(arg);
//        return tabFrag;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        TextView outText;

        outText = (TextView) rootView.findViewById(R.id.answer_1);
        outText.setMovementMethod(new ScrollingMovementMethod());

//        int sInt = getArguments().getInt("sInt", 0);
//        String sString = getArguments().getString("sString", "");

        TextView bilet = (TextView) rootView.findViewById(R.id.section_1);

        Bundle b = getArguments();
        if (b != null) {
            bilet.setText(b.getString("id", b.getString("id")));
        }


        return rootView;
    }

}
