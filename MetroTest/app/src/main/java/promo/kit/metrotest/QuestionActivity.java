package promo.kit.metrotest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class QuestionActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    private QOneFragment fr;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bundle b = getIntent().getExtras();

        String ticket = b.getString("id");
        int number = b.getInt("id2");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment class delete
     * <p>
     * /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {

                case 0:
                    Bundle b = getIntent().getExtras();
                    QOneFragment fr = QOneFragment.newInstance(b.getInt("id2"), b.getString("id"));

                    return fr;
                case 1:
                    Bundle b1 = getIntent().getExtras();
                    QTwoFragment frTwo = QTwoFragment.newInstance(b1.getInt("id2"), b1.getString("id"));
                    return frTwo;
                case 2:
                    Bundle b2 = getIntent().getExtras();
                    QThreeFragment frThree = QThreeFragment.newInstance(b2.getInt("id2"), b2.getString("id"));
                    return frThree;
                case 3:
                    Bundle b3 = getIntent().getExtras();
                    QFourFragment frFour = QFourFragment.newInstance(b3.getInt("id2"), b3.getString("id"));
                    return frFour;
                case 4:
                    Bundle b4 = getIntent().getExtras();
                    QFiveFragment frFive = QFiveFragment.newInstance(b4.getInt("id2"), b4.getString("id"));
                    return frFive;
                case 5:
                    Bundle b5 = getIntent().getExtras();
                    QSixFragment frSix = QSixFragment.newInstance(b5.getInt("id2"), b5.getString("id"));
                    return frSix;
                case 6:
                    Bundle b6 = getIntent().getExtras();
                    QSevenFragment frSeven = QSevenFragment.newInstance(b6.getInt("id2"), b6.getString("id"));
                    return frSeven;
                case 7:
                    Bundle b7 = getIntent().getExtras();
                    QEightFragment frEight = QEightFragment.newInstance(b7.getInt("id2"), b7.getString("id"));
                    return frEight;
                default:
                    return null;

            }
        }


        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "В 1";
                case 1:
                    return "В 2";
                case 2:
                    return "В 3";
                case 3:
                    return "В 4";
                case 4:
                    return "В 5";
                case 5:
                    return "В 6";
                case 6:
                    return "В 7";
                case 7:
                    return "В 8";
                default:
                    return null;

            }

        }
    }
}


