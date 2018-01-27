package xyz.hsuyeemon.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.GuideVO;
import xyz.hsuyeemon.burpple.viewholders.ItemBurppleGuideViewHolder;


/**
 * Created by Dell on 1/7/2018.
 */

public class BurppleGuideAdapter extends RecyclerView.Adapter<ItemBurppleGuideViewHolder> {

    private List<GuideVO> guideList;

    public BurppleGuideAdapter(){
        guideList = new ArrayList<>();
    }
    @Override
    public ItemBurppleGuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_burpple_guide,parent,false);
        ItemBurppleGuideViewHolder itemBurppleGuideViewHolder=new ItemBurppleGuideViewHolder(view);
        return itemBurppleGuideViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemBurppleGuideViewHolder holder, int position) {
        holder.setGuides(guideList.get(position));
    }


    @Override
    public int getItemCount() {
        return guideList.size();
    }

    public void setGuides(List<GuideVO> guideList){
        this.guideList=guideList;
        notifyDataSetChanged();

    }
}
