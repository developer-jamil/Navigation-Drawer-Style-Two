package com.jamillabltd.navigationdrawerstyletwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Default Set Fragment Home
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerId, new HomeFragment());
        transaction.commit();


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //drawer navigation item onclick action
        NavigationView navigationView = findViewById(R.id.navigationViewId);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            //How To Use
            if (id == R.id.howtoMenuId) {
                Toast.makeText(this, "How to Use", Toast.LENGTH_SHORT).show();
            }
            //Laws
            if (id == R.id.lawsMenuId) {
                Toast.makeText(this, "Lows", Toast.LENGTH_SHORT).show();
            }
            //About us
            if (id == R.id.aboutUsMenuId) {
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
            }
            //Settings
            if (id == R.id.settingsMenuId) {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            }


            //facebook page
            if (id == R.id.fbMenuId) {
                String url = Global_Link.facebookPage;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            //more
            if (id == R.id.moreMenuId) {
                String url = Global_Link.moreApp;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            //share
            if (id == R.id.shareMenuId) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String subject = getString(R.string.app_name);
                String body = subject + getString(R.string.share_text_dis) + "\n" +getString(R.string.google_play)+ Global_Link.landCalculator;
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(intent, "Share With "));
            }
            //privacy policy
            if (id == R.id.privacyMenuId) {
                String url = Global_Link.privacyPolicy;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            //rate us
            if (id == R.id.rateUsMenuId) {
                String url = Global_Link.landCalculator;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            //exit
            if (id == R.id.exitMenuId) {
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


    }


    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //navigation drawer
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        //option menu
        if (item.getItemId() == R.id.menuSettingId) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //set option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }



}