package com.example.todo; ///

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.ListFragment;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Map;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Список дел на сегодня
        ListView listView = findViewById(R.id.todoToday);

        App.DataHelper db = App.getInstance().getDatabase();


        ArrayAdapter<Map> adapter = new ArrayAdapter<Map>(this, R.layout.list_item);
        listView.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fab
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.fab:
                        switchScreen(v);
                        break;
                }
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
       /* //Working with date        String date_n = new SimpleDateFormat("MM dd, yyyy",
                Locale.getDefault()).format(new Date());
        TextView text = (TextView) findViewById(R.id.myDateText);
        text.setText(date_n);*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                TodayList list = new TodayList();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, list).commit();
                break;

            case R.id.nav_slideshow:
                break;

            case R.id.nav_tools:
                break;
        }
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

    public void switchScreen(View view){
        Intent intent = new Intent(this , NewTaskFirst.class);
        startActivity(intent);
    }

    /*public static Map<String, String> articleMapOne;
    static {
        articleMapOne = new HashMap<>();
        articleMapOne.put("ar01", "Intro to Map");
        articleMapOne.put("ar02", "Some article");
    }*/
}
