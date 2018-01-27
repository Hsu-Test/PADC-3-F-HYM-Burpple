package xyz.hsuyeemon.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 1/26/2018.
 */

public class FavFoodPlaceVO {

    @SerializedName("favorite_food_place_id")
    private int favoriteFoodPlaceId;

    private String title;
    private String address;
    private String photoUrl;

    public int getFavoriteFoodPlaceId() {
        return favoriteFoodPlaceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
