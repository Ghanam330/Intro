package com.example.introslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;


import com.example.introslider.Activity.PatchFragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PatchFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }// end if


    }// end  onCreate


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String title = getString(R.string.app_name);
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PatchFragment()).commit();
               // title=getString(R.string.title_home);
                break;
            case R.id.book:
                /*
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BookFragment()).commit();

                 */
               // title=getString(R.string.title_book);
                break;
            case R.id.library:
                /*
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ArticleFragment()).commit();

                 */
                title=getString(R.string.title_Library);
                break;
            case R.id.share:
                shara();
             //   title=getString(R.string.title_home);
                //code share

                break;
            case R.id.stars:
                //code stars
                stars();
             //   title=getString(R.string.title_home);
                break;
            case R.id.percon:
                //code person


              //  title=getString(R.string.title_percon);
                break;
            case R.id.send:
                send();
                //code send
               // title=getString(R.string.title_home);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        // set the toolbar title
        getSupportActionBar().setTitle(title);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }//end onBackPressed()

    public void stars() {
        final String appPackageName = getPackageName(); // getPackageName() طلبنا اسم الباكيج الخاص للتطبيق من هذا التطبيق, لو أردت تقييم تطبيق اخر ضع اسم الباكيج الخاصة به
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }// end stars

    private void shara() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "تطبيق ");
        i.putExtra(Intent.EXTRA_TEXT, "جرب هذا التطبيق اكثر من رائع\n" +
                "https://play.google.com/store/apps/details?id=com.example.introslider");
        startActivity(Intent.createChooser(i, "اختر التطبيق"));


    }// end

    public void send() {


        Intent mailIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + "subject text" + "&body=" + "body text" + "&to=" + "yghnam334455@gmail.com");
        mailIntent.setData(data);
        startActivity(Intent.createChooser(mailIntent, "Send mail..."));

    }


}//end class