package marinagirls.com;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import marinagirls.com.model.Trip;

/**
 * Created by david on 2/3/17.
 */

public class TripsFragment extends android.support.v4.app.Fragment {

    public static TripsFragment newInstance() {
        return new TripsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.trips_layout_list, container, false);
        final Activity activity = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutmanager);

        Trip t1 = new Trip("13:30");
        Trip t2 = new Trip("14:30");
        Trip t3 = new Trip("22:30");

        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(t1);
        trips.add(t2);
        trips.add(t3);


        recyclerView.setAdapter(new TripsAdapter(getActivity(),trips));

        return view;
    }


}
