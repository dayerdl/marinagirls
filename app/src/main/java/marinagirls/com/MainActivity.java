package marinagirls.com;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import marinagirls.com.activities.FacebookLoginActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TRIPS_FRAGMENT = "Trips";
    private static final String ADD_TRIP_FRAGMENT = "Add trip";
    private static final String MY_TRIPS_FRAGMENT = "My trips";
    BottomNavigationView bottomNavigationView;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupToolbar();
        addFragment(TRIPS_FRAGMENT);

    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(mToolbar);
    }



    private void setupViews() {
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_trips:
                                    addFragment(TRIPS_FRAGMENT);
                                break;
                            case R.id.action_add_trip:
                                    addFragment(ADD_TRIP_FRAGMENT);
                                break;
                            case R.id.action_my_trips:
                                    addFragment(MY_TRIPS_FRAGMENT);
                                break;
                        }
                        return false;
                    }
                });
    }

    private void addFragment(String tripsFragment) {
        mToolbar.setTitle(tripsFragment);
        if(tripsFragment.equals(TRIPS_FRAGMENT)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containter, TripsFragment.newInstance(), tripsFragment)
                    .commit();
        } else if(tripsFragment.equals(ADD_TRIP_FRAGMENT)){
            checkLogin();
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.containter, AddTripFragment.newInstance(), tripsFragment)
//                    .commit();
        } else if(tripsFragment.equals(MY_TRIPS_FRAGMENT)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containter, MyTripsFragment.newInstance(), tripsFragment)
                    .commit();
        }
    }

    private void checkLogin() {
        Intent i = new Intent(this, FacebookLoginActivity.class);
        startActivity(i);

    }


}
