package xyz.hsuyeemon.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 1/26/2018.
 */

public class FavFoodVO {

    @SerializedName("favorite_food_id")
    private int favoriteFoodId;

    private String title;
    private String photoUrl;

    public int getFavoriteFoodId() {
        return favoriteFoodId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
