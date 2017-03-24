package promo.kit.userregistration.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import promo.kit.userregistration.R;

public class AddNewUser extends AppCompatActivity {
    private static String FRAGMENT_INSTANCE_NAME = "fragment";
    AddNewUserFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_add);

        if (fragment == null) {
            fragment = new AddNewUserFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_add, fragment)
                    .commit();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

}
