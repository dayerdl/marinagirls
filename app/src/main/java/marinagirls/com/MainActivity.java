package marinagirls.com;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private static final String TRIPS_FRAGMENT = "Trips";
    private static final String ADD_TRIP_FRAGMENT = "Add";
    private static final String MY_TRIPS_FRAGMENT = "MyTrips";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        addFragment(TRIPS_FRAGMENT);

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
        if(tripsFragment.equals(TRIPS_FRAGMENT)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containter, TripsFragment.newInstance(), tripsFragment)
                    .commit();
        } else if(tripsFragment.equals(ADD_TRIP_FRAGMENT)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containter, AddTripFragment.newInstance(), tripsFragment)
                    .commit();
        } else if(tripsFragment.equals(MY_TRIPS_FRAGMENT)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containter, MyTripsFragment.newInstance(), tripsFragment)
                    .commit();
        }
    }


}
