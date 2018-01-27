package xyz.hsuyeemon.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.delegates.BeforeLoginUserDelegate;

/**
 * Created by Dell on 1/25/2018.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginUserDelegate mDelegate;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setDelegate(BeforeLoginUserDelegate delegate) {
        mDelegate = delegate;
    }

    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view) {
        mDelegate.onTapToLogin();
    }
}
