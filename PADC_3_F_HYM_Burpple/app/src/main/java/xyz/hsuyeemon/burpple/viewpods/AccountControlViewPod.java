package xyz.hsuyeemon.burpple.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.models.LoginUserModel;
import xyz.hsuyeemon.burpple.delegates.BeforeLoginUserDelegate;
import xyz.hsuyeemon.burpple.delegates.LoginUserDelegate;
import xyz.hsuyeemon.burpple.events.SuccessLoginEvent;
import xyz.hsuyeemon.burpple.events.UserLogoutEvent;

/**
 * Created by Dell on 1/25/2018.
 */

public class AccountControlViewPod extends FrameLayout {


   @BindView(R.id.vp_before_login)
   BeforeLoginViewPod vpBeforeLogin;

   @BindView(R.id.vp_login_user)
   LoginUserViewPod vpLoginUser;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        refreshUserSession();

        EventBus.getDefault().register(this);
    }

    public void setDelegate(BeforeLoginUserDelegate delegate){
        vpBeforeLogin.setDelegate(delegate);
    }
    public void setDelegate(LoginUserDelegate delegate){
        vpLoginUser.setDelegate(delegate);
    }


    public void refreshUserSession(){

        if(LoginUserModel.getObjectInstance().isUserLogin()){
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
        }
        else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
           vpLoginUser.setVisibility(View.GONE);

        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);
        vpLoginUser.bindData(event.getLoginUser());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }

}






