package promo.kit.metrotest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QThreeFragment extends Fragment {

    public static QThreeFragment newInstance(int number, String ticket) {
        QThreeFragment qFr = new QThreeFragment();
        Bundle b = new Bundle();
        b.putInt("number", number);
        b.putString("ticket", ticket);
        qFr.setArguments(b);
        return qFr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answer_three, container, false);
        TextView ticket = (TextView) rootView.findViewById(R.id.section_3);
        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));

        return rootView;
    }


}
