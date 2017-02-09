package promo.kit.metrotest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QTwoFragment extends Fragment {

    public static QTwoFragment newInstance(int number, String ticket) {
        QTwoFragment qFr = new QTwoFragment();
        Bundle b = new Bundle();
        b.putInt("number", number);
        b.putString("ticket", ticket);
        qFr.setArguments(b);
        return qFr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answer_two, container, false);
        TextView ticket = (TextView) rootView.findViewById(R.id.section_2);
        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));

        return rootView;
    }

}
