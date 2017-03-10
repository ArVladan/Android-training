package promo.kit.metrotest;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import promo.kit.metrotest.db.DatabaseHelper;

public class QOneFragment extends Fragment {

    private DatabaseHelper sqlHelper;
    private Cursor userCursor;
    private SimpleCursorAdapter userAdapter;
    private int tickets;


    @BindView(R.id.floatButton)
    FloatingActionButton fab;
    @BindView(R.id.save_text)
    ImageButton saveText;
    @BindView(R.id.edit_1)
    EditText editText;
    @BindView(R.id.answer_1)
    TextView outText;
    @BindView(R.id.section_1)
    TextView ticket;


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

        ButterKnife.bind(this, rootView);

        outText.setMovementMethod(new ScrollingMovementMethod());
        editText.setMovementMethod(new ScrollingMovementMethod());
        saveText.setVisibility(View.INVISIBLE);

        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));
        try {
            sqlHelper.open();
            tickets = getArguments().getInt("number");
            userCursor = sqlHelper.dbAnswer.query(DatabaseHelper.TABL_NAME,
                    new String[] {"answer_1"},
                    "_id = ?",
                    new String[] {Integer.toString(tickets)},
                    null, null, null);
            userCursor.moveToFirst();
            String a = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER_1));
            outText.setText(a);
            editText.setText(outText.getText());
            editText.setVisibility(View.INVISIBLE);

            }
            catch (SQLException ex){

            } catch (java.sql.SQLException e) {
                e.printStackTrace();
        }
        setRetainInstance(true);

        return rootView;
    }

    @OnClick(R.id.floatButton)
    public void performSend(View view) {
        if (outText.getVisibility() == View.VISIBLE) {
            outText.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.VISIBLE);
            saveText.setVisibility(View.VISIBLE);
            editText.requestFocus();
            InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editText, 0);
            saveText.setEnabled(true);

        }
        else {
            outText.setVisibility(View.VISIBLE);
            editText.setVisibility(View.INVISIBLE);
            saveText.setVisibility(View.INVISIBLE);
            saveText.setEnabled(false);
        }
    }

    @OnClick(R.id.save_text)
    public void onSaveText(View view) {
        outText.setText(editText.getText());
        try {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_ANSWER_1, outText.getText().toString());
            //Check DB on null
            if (getArguments().getInt("number") > 0) {
                sqlHelper.dbAnswer.update(DatabaseHelper.TABL_NAME, cv, "_id = ?", new String[] {Integer.toString(getArguments().getInt("number"))});
            } else {
                sqlHelper.dbAnswer.insert(DatabaseHelper.TABL_NAME, null, cv);
            }

        }
        catch (SQLException ex){ ex.printStackTrace();
        }

        outText.setVisibility(View.VISIBLE);
        editText.setVisibility(View.INVISIBLE);
        saveText.setVisibility(View.INVISIBLE);
        saveText.setEnabled(false);

        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключения
        sqlHelper.dbAnswer.close();
        userCursor.close();
    }


}
