package xyz.hsuyeemon.burpple.networks.responses;

import com.google.gson.annotations.SerializedName;

import xyz.hsuyeemon.burpple.data.vo.FavFoodPlaceVO;
import xyz.hsuyeemon.burpple.data.vo.FavFoodVO;
import xyz.hsuyeemon.burpple.data.vo.LoginUserVO;

/**
 * Created by Dell on 1/26/2018.
 */

public class GetLoginUserResponse {

    private int code;
    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUser;

    @SerializedName("fav_foods")
    private FavFoodVO favFood;

    @SerializedName("fav_food_places")
    private FavFoodPlaceVO favFoodPlace;

    public int getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public FavFoodVO getFavFood() {
        return favFood;
    }

    public FavFoodPlaceVO getFavFoodPlace() {
        return favFoodPlace;
    }
}
