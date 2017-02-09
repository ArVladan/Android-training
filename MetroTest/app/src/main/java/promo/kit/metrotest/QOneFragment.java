package promo.kit.metrotest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QOneFragment extends Fragment {

    public static QOneFragment newInstance(int number, String ticket) {
        QOneFragment qFr = new QOneFragment();
        Bundle arg = new Bundle();
        arg.putInt("number", number);
        arg.putString("ticket", ticket);
        qFr.setArguments(arg);
        return qFr;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answer_one, container, false);
        TextView outText;

        outText = (TextView) rootView.findViewById(R.id.answer_1);
        outText.setMovementMethod(new ScrollingMovementMethod());

        TextView ticket = (TextView) rootView.findViewById(R.id.section_1);
        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));

        return rootView;
    }

}
