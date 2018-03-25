package com.example.anurag.myfinalapp;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout = null;
    private NavigationView navigationView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Replace Toolbar with ActionBar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set the main content
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        //Set the title of all the tabs
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);

        //Set the listener for click events in navigation window.
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set ActionBarDrawerToggle for drawerlayout.
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        //Listen to click of 3 bars for navigation window and change animation
        drawerLayout.addDrawerListener(toggle);
        //Sets the icon (3 bars)
        toggle.syncState();

        //FloatingActionBar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.viewpager), "Yo Hello", Snackbar.LENGTH_LONG).show();
            }
        });

        //Not Working...
        //Works if the button is in activity_main.xml.
//        LayoutInflater inflater = getLayoutInflater();
//        View view = inflater.inflate(R.layout.nav_header, navigationView, false);
//        ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggle);
//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.d("Tag", "in");
//                Toast.makeText(MainActivity.this, "Change Successful!", Toast.LENGTH_LONG).show();
//                drawerLayout.closeDrawers();
//            }
//        });
    }

    //Create Overflow menu and inflate the menu(parameter passed by some method inside the app) with the menu we want.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action, menu);
        return true;
    }

    //Want you want to do for click events in overflow menu.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Setting: {

            }
        }

        return true;
    }

    //Manage click events for clicks in Navigation Drawer.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Cases (Eg. case R.id.camera:{})
            case R.id.camera: {
                Snackbar.make(findViewById(R.id.rel_layout), "dsafnask", Snackbar.LENGTH_LONG).show();
            }
        }
        drawerLayout.closeDrawers();
        return true;
    }

    //OnClick method for toggle button defined in nav_header.
    //Working Bro...Yey (didn't want spelling mistakes :P)
    public void changestate(View view) {
        Toast.makeText(MainActivity.this, "Changed!", Toast.LENGTH_LONG).show();
        Menu menu = navigationView.getMenu();
        if(menu.findItem(R.id.item1).isVisible()) {
            menu.findItem(R.id.item1).setVisible(false);
            menu.findItem(R.id.item2).setVisible(true);
        }
        else
        {
            menu.findItem(R.id.item1).setVisible(true);
            menu.findItem(R.id.item2).setVisible(false);
        }
    }
}
