package com.example.gallery_app;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.gallery_app.Fragment.ImageFragment;
import com.example.gallery_app.Fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView btmNav;
    private FrameLayout frame;
    ImageFragment imgFrag;
    VideoFragment videoFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        runOnUi(imgFrag);

        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch(menuItem.getItemId()) {
                        case R.id.menuImage:
                            runOnUi(imgFrag);
                            return true;
                        case R.id.menuVideo:
                            runOnUi(videoFrag);
                            return true;

                         default:
                             return false;
                    }
                }
            });

    }

    private void initialization(){
                btmNav=findViewById(R.id.btmview);
                frame=findViewById(R.id.frameLayout);
                videoFrag=new VideoFragment();
                imgFrag=new ImageFragment();

             }

    private void runOnUi(Fragment Frag) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,Frag);
                fragmentTransaction.commit();
            }

}
