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
import co.paulfran.paulfranco.materialtabs.adapters.IconTabsAdapter;
import co.paulfran.paulfranco.materialtabs.adapters.TextTabsAdapter;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentFive;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentFour;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentOne;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentSix;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentThree;
import co.paulfran.paulfranco.materialtabs.fragments.FragmentTwo;

public class IconTabs extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();

    // initialize viewPager (set as field variable)
    private ViewPager viewPager;

    // initialize adapter (set as field variable)
    private IconTabsAdapter adapter;

    // initialize TabLayout
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_tabs);

        initialize();

        prepareDataResource();

        // complete initialization of adapter
        adapter = new IconTabsAdapter(getSupportFragmentManager(), fragmentList);

        // Bind adapter to viewPager
        viewPager.setAdapter(adapter);

        // Bind tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();
    }

    private void initialize() {

        // initialize toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Simple Icon Tabs Example");

        // complete initialization of viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        // complete initialization of tabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabs);

    }

    private void prepareDataResource() {

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());
        fragmentList.add(new FragmentFive());
        fragmentList.add(new FragmentSix());
    }

    private void setTabIcons() {

        tabLayout.getTabAt(0).setIcon(R.drawable.facebook);
        tabLayout.getTabAt(1).setIcon(R.drawable.linkedin);
        tabLayout.getTabAt(2).setIcon(R.drawable.whatsapp);
        tabLayout.getTabAt(3).setIcon(R.drawable.youtube);
        tabLayout.getTabAt(4).setIcon(R.drawable.twitter);
        tabLayout.getTabAt(5).setIcon(R.drawable.googleplus);

    }

}
