package com.example.gallery_app.Actvity;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.gallery_app.Fragment.ImageFragment;
import com.example.gallery_app.Fragment.VideoFragment;
import com.example.gallery_app.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView btmNav;
    private FrameLayout frame;
    ImageFragment imgFrag;
    VideoFragment videoFrag;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                System.exit(0);
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("TAG","onCrete");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Restart App", Toast.LENGTH_LONG).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }


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
                imgFrag= new ImageFragment();

             }

    private void runOnUi(Fragment Frag) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,Frag);
                fragmentTransaction.commit();
            }

}
