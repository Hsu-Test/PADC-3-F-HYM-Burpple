package xyz.hsuyeemon.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.vo.LoginUserVO;
import xyz.hsuyeemon.burpple.delegates.LoginUserDelegate;
import xyz.hsuyeemon.burpple.events.UserLogoutEvent;

/**
 * Created by Dell on 1/26/2018.
 */

public class LoginUserViewPod extends RelativeLayout {

    @BindView(R.id.iv_user_profile)
    ImageView ivUserProfile;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_phone_no)
    TextView tvPhoneNo;

    @BindView(R.id.iv_bg)
    ImageView ivBg;

    private LoginUserDelegate mDelegate;

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void bindData(LoginUserVO loginUser) {
        tvName.setText(loginUser.getName());
        tvPhoneNo.setText(loginUser.getPhoneNo());

        Glide.with(ivUserProfile.getContext())
                .load(loginUser.getProfileUrl())
                .into(ivUserProfile);

        Glide.with(ivBg.getContext())
                .load(loginUser.getCoverUrl())
                .into(ivBg);
    }


    public void setDelegate(LoginUserDelegate loginUserDelegate) {
        mDelegate = loginUserDelegate;
    }

    @OnClick(R.id.btn_to_logout)
    public void onTapLogout(View view) {
        mDelegate.onTapLogout();
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }
}
