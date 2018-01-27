package xyz.hsuyeemon.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.PromotionVO;


/**
 * Created by Dell on 1/6/2018.
 */

public class ItemPromotionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_dummy_food)
    ImageView ivDummyFood;

    @BindView(R.id.tv_burpple_exclusive)
    TextView tvBurppleExclusive;

    @BindView(R.id.tv_express_promotion)
    TextView tvExpressPromotion;

    @BindView(R.id.tv_due_date)
    TextView tvDueDate;

    @BindView(R.id.tv_description_shop)
    TextView tvDescriptionShop;

    @BindView(R.id.tv_description_place)
    TextView tvDescriptionPlace;

    private PromotionVO mPromotion;

    public ItemPromotionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setPromotion(PromotionVO promotion){
        mPromotion=promotion;

        Glide.with(ivDummyFood.getContext())
                .load(mPromotion.getBurpplePromotionImage())
                .into(ivDummyFood);

        if(mPromotion.isBurppleExclusive()==false){
            tvBurppleExclusive.setVisibility(View.GONE);
        }
        tvExpressPromotion.setText(mPromotion.getBurpplePromotionTitle());
        tvDueDate.setText(mPromotion.getBurpplePromotionUntil());
        tvDescriptionShop.setText(mPromotion.getBurpplePromotionShop().getShopName());
        tvDescriptionPlace.setText(mPromotion.getBurpplePromotionShop().getBurppleShopArea());

    }

}
