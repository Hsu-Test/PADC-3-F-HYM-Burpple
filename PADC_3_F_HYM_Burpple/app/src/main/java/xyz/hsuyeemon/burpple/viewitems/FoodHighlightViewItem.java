package xyz.hsuyeemon.burpple.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.FeaturedVO;

/**
 * Created by Dell on 1/6/2018.
 */

public class FoodHighlightViewItem extends RelativeLayout {

    @BindView(R.id.iv_dummy_food_background)
    ImageView ivDummyFoodBackground;

    @BindView(R.id.tv_features)
    TextView tvFeatures;

    @BindView(R.id.tv_highlight_title)
    TextView tvHighlightTitle;

    @BindView(R.id.tv_describe_location)
    TextView tvDescribeLocation;

    private FeaturedVO featured;

    public FoodHighlightViewItem(@NonNull Context context) {
        super(context);
    }

    public FoodHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FoodHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setData(FeaturedVO featured){
        this.featured=featured;

        Glide.with(ivDummyFoodBackground.getContext())
                .load(featured.getBurppleFeaturedImage())
                .into(ivDummyFoodBackground);

        tvFeatures.setText(featured.getBurppleFeaturedTag());
        tvHighlightTitle.setText(featured.getBurppleFeaturedTitle());
        tvDescribeLocation.setText(featured.getBurppleFeaturedDesc());

    }
}
