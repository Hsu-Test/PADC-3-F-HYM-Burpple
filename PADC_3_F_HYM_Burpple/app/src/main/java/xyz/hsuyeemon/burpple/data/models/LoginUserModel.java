package xyz.hsuyeemon.burpple.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.hsuyeemon.burpple.data.vo.LoginUserVO;
import xyz.hsuyeemon.burpple.events.SuccessLoginEvent;
import xyz.hsuyeemon.burpple.networks.dataagents.BurppleFoodPlaceDataAgent;
import xyz.hsuyeemon.burpple.networks.dataagents.RetrofitDataAgent;

/**
 * Created by Dell on 1/26/2018.
 */

public class LoginUserModel {

    private static LoginUserModel loginUserModel;
    private BurppleFoodPlaceDataAgent mDataAgent;
    private LoginUserVO mLoginUser;

    private LoginUserModel(){
        mDataAgent = RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getObjectInstance(){
        if(loginUserModel == null){
            loginUserModel = new LoginUserModel();
        }
        return loginUserModel;
    }

    public void loginUser(String phoneNo,String password){
        mDataAgent.loginUser(phoneNo,password);

    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessLogin(SuccessLoginEvent event){
        mLoginUser = event.getLoginUser();
    }


    public boolean isUserLogin(){
        return mLoginUser!=null;
      /*  if(mLoginUser == null){
            return false;
        }
        else
            return true;
            */
    }

    public void logout(){
        mLoginUser = null;
    }

 }
