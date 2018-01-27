package xyz.hsuyeemon.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.viewholders.ItemTrendingVenueViewHolder;


/**
 * Created by Dell on 1/9/2018.
 */

public class TrendingVenuesAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_trending_venue,parent,false);
        ItemTrendingVenueViewHolder itemTrendingVenueViewHolder=new ItemTrendingVenueViewHolder(view);
        return itemTrendingVenueViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
