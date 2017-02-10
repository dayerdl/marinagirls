package marinagirls.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import marinagirls.com.R;
import marinagirls.com.model.Trip;

/**
 * Created by David on 2/3/17.
 */
public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private ArrayList<Trip> mTrips;

    public TripsAdapter(Context context, ArrayList<Trip> trips){
        mTrips = trips;
        mLayoutInflater = LayoutInflater.from(context);
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(mLayoutInflater
                .inflate(R.layout.row_trip, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String time = mTrips.get(position).time;
        holder.setData(time);
    }

    @Override
    public int getItemCount() {
        return mTrips.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.time);
        }

        private void setData(String name) {
            mNameTextView.setText(name);
        }
    }
}
