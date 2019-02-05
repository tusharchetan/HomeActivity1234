package com.example.homeactivity.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.homeactivity.R;
import com.example.homeactivity.utils.BottomNavigationViewHelper;
import com.example.homeactivity.utils.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class  AccountSetting extends AppCompatActivity {

    private Context mContext;
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mContext = AccountSetting.this;
        setupFragment();
        setupSettingsList();
        ImageView imageView = findViewById(R.id.backArrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewPager = findViewById(R.id.container);
        relativeLayout = findViewById(R.id.relLayout1);
        setupBottomNavigationView();
    }
    private void setupFragment()
    {
    pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
    pagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile));
    pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out));
    }
    private void seupViewPager(int FragmentNumber){
        relativeLayout.setVisibility(View.GONE);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(FragmentNumber);
    }
    private void setupSettingsList()
    {
        ListView listView = findViewById(R.id.lvAccountSettings);
        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add("Sign out");
        ArrayAdapter adapter = new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seupViewPager(position);
            }
        });
    }

    private void setupBottomNavigationView(){
        Log.d("Account Settings","BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx =findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(AccountSetting.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

    }
}
