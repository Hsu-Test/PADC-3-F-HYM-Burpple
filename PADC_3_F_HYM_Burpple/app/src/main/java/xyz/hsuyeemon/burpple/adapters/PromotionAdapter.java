package xyz.hsuyeemon.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.PromotionVO;
import xyz.hsuyeemon.burpple.viewholders.ItemPromotionViewHolder;


/**
 * Created by Dell on 1/6/2018.
 */

public class PromotionAdapter extends RecyclerView.Adapter<ItemPromotionViewHolder> {

    private List<PromotionVO> mPromotionList;

    public PromotionAdapter(){

        mPromotionList= new ArrayList<>();
    }
    @Override
    public ItemPromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_promotion,parent,false);
        ItemPromotionViewHolder itemPromotionViewHolder=new ItemPromotionViewHolder(view);
        return itemPromotionViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemPromotionViewHolder holder, int position) {
        holder.setPromotion(mPromotionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotion(List<PromotionVO> promotionList){
        mPromotionList=promotionList;
        notifyDataSetChanged();
    }
}
