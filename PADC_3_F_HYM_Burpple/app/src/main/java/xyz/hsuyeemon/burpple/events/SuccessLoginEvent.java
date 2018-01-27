package xyz.hsuyeemon.burpple.events;

import xyz.hsuyeemon.burpple.data.vo.LoginUserVO;

/**
 * Created by Dell on 1/26/2018.
 */

public class SuccessLoginEvent {

    private LoginUserVO loginUser;

    public SuccessLoginEvent(LoginUserVO loginUser){
        this.loginUser = loginUser;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
