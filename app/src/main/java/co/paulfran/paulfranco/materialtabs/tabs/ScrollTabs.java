package co.paulfran.paulfranco.materialtabs.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import co.paulfran.paulfranco.materialtabs.R;
import co.paulfran.paulfranco.materialtabs.adapters.ScrollTabsAdapter;
import co.paulfran.paulfranco.materialtabs.adapters.TextTabsAdapter;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentFive;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentFour;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentOne;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentSix;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentThree;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentTwo;

public class ScrollTabs extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    // initialize viewPager (set as field variable)
    private ViewPager viewPager;

    // initialize adapter (set as field variable)
    private ScrollTabsAdapter adapter;

    // initialize TabLayout
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tabs);

        initialize();

        prepareDataResource();

        // complete initialization of adapter
        adapter = new ScrollTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);

        // Bind adapter to viewPager
        viewPager.setAdapter(adapter);

        // Bind tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initialize() {

        // initialize toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Simple Scroll Tabs Example");

        // complete initialization of viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        // complete initialization of tabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabs);

    }

    private void prepareDataResource() {

        // This is the same as below with the use of addData()
        addData(new FragmentOne(), "ONE");
        addData(new FragmentTwo(), "TWO");
        addData(new FragmentThree(), "THREE");
        addData(new FragmentFour(), "FOUR");
        addData(new FragmentFive(), "FIVE");
        addData(new FragmentSix(), "SIX");
        addData(new FragmentOne(), "SEVEN");
        addData(new FragmentTwo(), "EIGHT");
        addData(new FragmentThree(), "NINE");
        addData(new FragmentFour(), "TEN");
        addData(new FragmentFive(), "ELEVEN");
        addData(new FragmentSix(), "TWELVE");

        // This is the same as above but with no use of addData()
        //fragmentList.add(new FragmentOne());
        //titleList.add("ONE");

        //fragmentList.add(new FragmentTwo());
        //titleList.add("TWO");

        //fragmentList.add(new FragmentThree());
        //titleList.add("THREE");

    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }



}
