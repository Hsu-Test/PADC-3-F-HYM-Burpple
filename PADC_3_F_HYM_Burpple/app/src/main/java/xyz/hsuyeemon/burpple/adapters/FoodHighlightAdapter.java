package xyz.hsuyeemon.burpple.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.FeaturedVO;
import xyz.hsuyeemon.burpple.viewitems.FoodHighlightViewItem;


/**
 * Created by Dell on 1/6/2018.
 */

public class FoodHighlightAdapter extends PagerAdapter {

    private List<FeaturedVO> featuredList;

    public FoodHighlightAdapter(){
        featuredList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return featuredList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(View)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Context context=container.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);

        FoodHighlightViewItem view=(FoodHighlightViewItem)inflater.inflate(R.layout.item_food_highlight,container,false);

        view.setData(featuredList.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    public void setFeatures(List<FeaturedVO> featuresList){
        this.featuredList=featuresList;
        notifyDataSetChanged();
    }


}
