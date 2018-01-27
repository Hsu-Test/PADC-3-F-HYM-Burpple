package xyz.hsuyeemon.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.GuideVO;

/**
 * Created by Dell on 1/7/2018.
 */

public class ItemBurppleGuideViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_burpple_guide_bg)
    ImageView ivBurppleGuideBg;

    @BindView(R.id.tv_food_type)
    TextView tvFoodType;


    private GuideVO guide;


    public ItemBurppleGuideViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setGuides(GuideVO guide){
        this.guide=guide;

        Glide.with(ivBurppleGuideBg.getContext())
                .load(guide.getBurppleGuideImage())
                .into(ivBurppleGuideBg);

        tvFoodType.setText(guide.getBurppleGuideTitle());

    }
}
