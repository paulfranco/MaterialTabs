package co.paulfran.paulfranco.materialtabs.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.paulfran.paulfranco.materialtabs.R;
import co.paulfran.paulfranco.materialtabs.adapters.CustomTabsAdapter;
import co.paulfran.paulfranco.materialtabs.adapters.TextTabsAdapter;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentOne;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentThree;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentTwo;

public class CustomTabs extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    // initialize viewPager (set as field variable)
    private ViewPager viewPager;

    // initialize adapter (set as field variable)
    private CustomTabsAdapter adapter;

    // initialize TabLayout
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_tabs);

        initialize();

        prepareDataResource();

        // complete initialization of adapter
        adapter = new CustomTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);

        // Bind adapter to viewPager
        viewPager.setAdapter(adapter);

        // Bind tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager);

        setCustomTabs();
    }


    private void initialize() {

        // initialize toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Custom Tabs Example");

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

    private void setCustomTabs() {

        // Dont need this block of code because we will use the setCustomViewForTab()
        // LinearLayout tabView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_item, null);

        // TextView tabTextTitle = (TextView) tabView.findViewById(R.id.tabTextTitle);
        // tabTextTitle.setText("WALL");

        // TextView tabTextSubTitle = (TextView) tabView.findViewById(R.id.tabTextSubTitle);
        // tabTextSubTitle.setText("TAB ONE");

        // tabLayout.getTabAt(0).setCustomView(tabView);

        setCustomViewForTab(0, "WALL", "TAB ONE");
        setCustomViewForTab(1, "CHAT", "TAB TWO");
        setCustomViewForTab(2, "PROFILE", "TAB THREE");
    }

    private void setCustomViewForTab(int position, String title, String subTitle) {

        LinearLayout tabView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_item, null);

        TextView tabTextTitle = (TextView) tabView.findViewById(R.id.tabTextTitle);
        tabTextTitle.setText(title);

        TextView tabTextSubTitle = (TextView) tabView.findViewById(R.id.tabTextSubTitle);
        tabTextSubTitle.setText(subTitle);

        tabLayout.getTabAt(position).setCustomView(tabView);

    }



}
