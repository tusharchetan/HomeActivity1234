package com.example.homeactivity.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.GridView;

import com.example.homeactivity.R;
import com.example.homeactivity.utils.BottomNavigationViewHelper;
import com.example.homeactivity.utils.GridImageAdapter;
import com.example.homeactivity.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String Tag ="ProfileActivity";
    private ProgressBar progressBar;
    private ImageView imageView;
    private Context mContext;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = ProfileActivity.this;
        setContentView(R.layout.activity_profile);
        setupBottomNavigationView();
        setupToolbar();

        imageView = findViewById(R.id.profile_image);
        progressBar = findViewById(R.id.profileprogressbar);
        setupImageLoader();
        setupImage();
        tempGridSetup();
        progressBar.setVisibility(View.GONE);
    }

    private void setupImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(ProfileActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
    private void setupImage(){
        UniversalImageLoader.setImage("https://i.ytimg.com/vi/WyGSHUrEeCc/hqdefault_live.jpg",imageView,progressBar,"");
    }
    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://www.oxforduniversityimages.com/images/rotate/Image_Spring_17_2.gif");
        imgURLs.add("http://cincinnatizoo.org/wp-content/uploads/2015/08/gorilla-baby-300x300.jpg");
        imgURLs.add("https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg");
        imgURLs.add("https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg");
        imgURLs.add("https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg");
        imgURLs.add("https://cdn.pixabay.com/photo/2016/06/18/17/42/image-1465348_960_720.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg");
        imgURLs.add("https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("https://cdn.pixabay.com/photo/2016/06/18/17/42/image-1465348_960_720.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");
        imgURLs.add("https://www.oxforduniversityimages.com/images/rotate/Image_Spring_17_2.gif");
        imgURLs.add("http://cincinnatizoo.org/wp-content/uploads/2015/08/gorilla-baby-300x300.jpg");
        setupImageGrid(imgURLs);
    }
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int ImageWidth = gridWidth/3;
        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }
    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView imageView = findViewById(R.id.newProfileMenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,AccountSetting.class);
                startActivity(intent);
            }
        });
    }
    private void setupBottomNavigationView(){
        Log.d(Tag,"BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx =(BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }


}
