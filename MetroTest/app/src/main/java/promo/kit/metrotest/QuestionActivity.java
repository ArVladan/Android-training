package promo.kit.metrotest;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import promo.kit.metrotest.model.Tab1;
import promo.kit.metrotest.model.Tab2;
import promo.kit.metrotest.model.Tab3;
import promo.kit.metrotest.model.Tab4;
import promo.kit.metrotest.model.Tab5;
import promo.kit.metrotest.model.Tab6;

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
    private ViewPager mViewPager;

//    public static Tab1 newInstance(int sInt, String sString) {
//        Tab1 tabFrag = new Tab1();
//        Bundle arg = new Bundle();
//        arg.putInt("sInt", sInt);
//        arg.putString("sString", sString);
//        tabFrag.setArguments(arg);
//        return tabFrag;
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bundle b = getIntent().getExtras();

        //data for Fragment tab1

        b.putString("id", b.getString("id"));
        Tab1 tab = new Tab1();
        tab.setArguments(b);




//        TextView bilet = (TextView) findViewById(R.id.answer_1);
//        bilet.setText("" + b.getInt("id"));
//        TextView outText;
//
//        outText = (TextView) this.findViewById(R.id.answer_1);
//        outText.setMovementMethod(new ScrollingMovementMethod());


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

                    Tab1 tab1 = new Tab1();
                    return tab1;
                case 1:
                    Tab2 tab2 = new Tab2();
                    return tab2;
                case 2:
                    Tab3 tab3 = new Tab3();
                    return tab3;
                case 3:
                    Tab4 tab4 = new Tab4();
                    return tab4;
                case 4:
                    Tab5 tab5 = new Tab5();
                    return tab5;
                case 5:
                    Tab6 tab6 = new Tab6();
                    return tab6;
                default:
                    return null;

            }
        }


        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Вопрос 1";
                case 1:
                    return "Вопрос 2";
                case 2:
                    return "Вопрос 3";
                case 3:
                    return "Вопрос 4";
                case 4:
                    return "Вопрос 5";
                case 5:
                    return "Вопрос 6";
                default:
                    return null;

            }

        }
    }
}


