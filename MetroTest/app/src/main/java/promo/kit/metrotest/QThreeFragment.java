package promo.kit.metrotest;

import android.app.Service;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
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

public class QThreeFragment extends Fragment {
    private DatabaseHelper sqlHelper;
    private Cursor userCursor;
    private int tickets;

    @BindView(R.id.floatButton3)
    FloatingActionButton fab;
    @BindView(R.id.save_text3)
    ImageButton saveText;
    @BindView(R.id.edit_3)
    EditText editText;
    @BindView(R.id.answer_3)
    TextView outText;
    @BindView(R.id.section_3)
    TextView ticket;

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
        sqlHelper = new DatabaseHelper(this.getContext().getApplicationContext());
        sqlHelper.create_db();

        ButterKnife.bind(this, rootView);

        outText.setMovementMethod(new ScrollingMovementMethod());
        editText.setMovementMethod(new ScrollingMovementMethod());
        saveText.setVisibility(View.INVISIBLE);

        ticket.setText(getArguments().getString("ticket") + " " + getArguments().getInt("number"));

        try {
            sqlHelper.open();
            int tickets = getArguments().getInt("number");
            userCursor = sqlHelper.dbAnswer.query(DatabaseHelper.TABL_NAME,
                    new String[] {"answer_3"},
                    "_id = ?",
                    new String[] {Integer.toString(tickets)},
                    null, null, null);
            userCursor.moveToFirst();
            String a = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER_3));
            outText.setText(a);
            editText.setText(outText.getText());
            editText.setVisibility(View.INVISIBLE);

        }
        catch (SQLException ex){} catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        setRetainInstance(true);
        return rootView;
    }

    @OnClick(R.id.floatButton3)
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

    @OnClick(R.id.save_text3)
    public void onSaveText(View view) {
        outText.setText(editText.getText());
        try {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_ANSWER_3, outText.getText().toString());
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
    public void onDestroy(){
        super.onDestroy();
        sqlHelper.dbAnswer.close();
        userCursor.close();
    }


}
