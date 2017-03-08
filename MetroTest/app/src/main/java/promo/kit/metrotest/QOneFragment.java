package promo.kit.metrotest;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import promo.kit.metrotest.db.DatabaseHelper;

public class QOneFragment extends Fragment {

    private DatabaseHelper sqlHelper;
    private Cursor userCursor;
    private SimpleCursorAdapter userAdapter;

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
        sqlHelper = new DatabaseHelper(this.getContext().getApplicationContext());
        // создаем базу данных
        sqlHelper.create_db();


        TextView outText;

        outText = (TextView) rootView.findViewById(R.id.answer_1);
        outText.setMovementMethod(new ScrollingMovementMethod());

        TextView ticket = (TextView) rootView.findViewById(R.id.section_1);
        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));
        try {
            sqlHelper.open();
            int tickets = getArguments().getInt("number");
            userCursor = sqlHelper.dbAnswer.query(DatabaseHelper.TABL_NAME,
                    new String[] {"answer_1"},
                    "_id = ?",
                    new String[] {Integer.toString(tickets)},
                    null, null, null);
            userCursor.moveToFirst();
            String a = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER_1));
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
        // Закрываем подключения
        sqlHelper.dbAnswer.close();
        userCursor.close();
    }


}
