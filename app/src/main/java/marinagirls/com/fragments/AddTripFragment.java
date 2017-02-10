package marinagirls.com.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import marinagirls.com.R;
import marinagirls.com.addtrips.AddTripPresenter;

/**
 * Created by David on 2/3/17.
 */
public class AddTripFragment extends Fragment {

    AddTripPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_trip, container, false);
        setupView(view);
        return view;
    }

    private void setupView(View view) {

    }

    public static Fragment newInstance() {
        return new AddTripFragment();
    }
}
