package com.example.darshilbhayani.meetup_group1mobileapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ProfilePage extends AppCompatActivity {

    private Button button_myplan;
    private  Button  button_joinedplan;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);


//App Drawer Button
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override

            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.nav_Addplan) {
                // Handle the camera action
                    Intent i = new Intent(ProfilePage.this, CreatePage1.class);
                    startActivity(i);
                } else if (id == R.id.nav_contacts) {
                    Intent i = new Intent(ProfilePage.this,User.class );
                    startActivity(i);

                } else if (id == R.id.nav_Map) {
                    Intent i = new Intent(ProfilePage.this, MapsActivity.class);

                    startActivity(i);

                } else if (id == R.id.nav_settings) {
                    Intent i = new Intent(ProfilePage.this, Settings_main.class);
                    startActivity(i);
                }
                return true;
            }

        });

/////

        button_joinedplan = findViewById(R.id.button_joinplan);
        button_myplan = findViewById(R.id.button_myplan);

        button_myplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(ProfilePage.this);
                builderSingle.setIcon(R.drawable.ic_launcher_background);
                builderSingle.setTitle("Select One Name:-");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ProfilePage.this, android.R.layout.select_dialog_singlechoice);

                arrayAdapter.add("Hardik");
                arrayAdapter.add("Archit");
                arrayAdapter.add("Jignesh");
                arrayAdapter.add("Umang");
                arrayAdapter.add("Gatti");

                builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(ProfilePage.this);
                        builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                dialog.dismiss();
                            }
                        });
                    }
                });
                builderSingle.show();

            }
        });




        button_joinedplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(ProfilePage.this).create(); //Read Update
                alertDialog.setTitle("Joined Plan");
                alertDialog.setMessage("This Alert box displays plans that I have joined in");

                alertDialog.setButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();  //<-- See This!
            }

        });
            }


            //APP Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




