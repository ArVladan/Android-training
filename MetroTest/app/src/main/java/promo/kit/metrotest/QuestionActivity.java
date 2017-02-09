package promo.kit.metrotest;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

//    public static QuestOne newInstance(int sInt, String sString) {
//        QuestOne tabFrag = new QuestOne();
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

        QuestOne fr = QuestOne.newInstance(b.getInt("id2"), b.getString("id"));

//        b.putString("id", b.getString("id"));
//        QuestOne tab = new QuestOne();
//        tab.setArguments(b);




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

                    QuestOne questOne = new QuestOne();
                    return questOne;
                case 1:
                    QuestTwo questTwo = new QuestTwo();
                    return questTwo;
                case 2:
                    QuestThree questThree = new QuestThree();
                    return questThree;
                case 3:
                    QuestFour questFour = new QuestFour();
                    return questFour;
                case 4:
                    QuestFive questFive = new QuestFive();
                    return questFive;
                case 5:
                    QuestSix questSix = new QuestSix();
                    return questSix;
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


