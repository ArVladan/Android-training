package promo.kit.metrotest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab1 extends Fragment {

    public static Tab1 newInstance(String sString, int sInt) {
        final Tab1 tabFrag = new Tab1();
        final Bundle b = new Bundle();
        b.putInt("sInt", sInt);
        b.putString("sString", sString);
        tabFrag.setArguments(b);
        return tabFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        TextView outText;

        outText = (TextView) rootView.findViewById(R.id.answer_1);
        outText.setMovementMethod(new ScrollingMovementMethod());

        TextView ticket = (TextView) rootView.findViewById(R.id.section_1);

        if (getArguments() != null) {
            String tickets = getArguments().getString("sString", "");
            int number = getArguments().getInt("sInt", 0);
            ticket.setText(tickets + number);
        }else {
            throw new IllegalArgumentException("Must be created through newInstance(...)");
        }




        return rootView;
    }


}
