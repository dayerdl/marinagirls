package marinagirls.com;

import android.app.Activity;
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
 * Created by David on 2/3/17.
 */

public class MyTripsFragment extends android.support.v4.app.Fragment {

    public static MyTripsFragment newInstance() {
        return new MyTripsFragment();
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

        Trip t1 = new Trip("12:22");


        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(t1);



        recyclerView.setAdapter(new TripsAdapter(getActivity(),trips));

        return view;
    }


}
