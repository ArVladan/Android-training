package promo.kit.metrotest;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import promo.kit.metrotest.db.DatabaseHelper;

public class QTwoFragment extends Fragment {
    private DatabaseHelper sqlHelper;
    private Cursor userCursor;

    @BindView(R.id.answer_2)
    TextView outText;
    @BindView(R.id.section_2)
    TextView ticket;



    public static QTwoFragment newInstance(int number, String ticket) {
        QTwoFragment qFr2 = new QTwoFragment();
        Bundle b = new Bundle();
        b.putInt("number", number);
        b.putString("ticket", ticket);
        qFr2.setArguments(b);
        return qFr2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answer_two, container, false);
        sqlHelper = new DatabaseHelper(this.getContext().getApplicationContext());
        sqlHelper.create_db();

        ButterKnife.bind(this, rootView);

        outText.setMovementMethod(new ScrollingMovementMethod());
        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));

        try {
            sqlHelper.open();
            int tickets = getArguments().getInt("number");
            userCursor = sqlHelper.dbAnswer.query(DatabaseHelper.TABL_NAME,
                    new String[] {"answer_2"},
                    "_id = ?",
                    new String[] {Integer.toString(tickets)},
                    null, null, null);
            userCursor.moveToFirst();
            String a = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER_2));
            outText.setText(a);

        }
        catch (SQLException ex){} catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        setRetainInstance(true);
        return rootView;
    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        sqlHelper.dbAnswer.close();
        userCursor.close();
    }

}
