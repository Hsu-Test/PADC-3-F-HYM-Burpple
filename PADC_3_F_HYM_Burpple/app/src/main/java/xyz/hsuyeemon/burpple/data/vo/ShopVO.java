package xyz.hsuyeemon.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 1/13/2018.
 */

public class ShopVO {

    @SerializedName("burpple-shop-id")
    private String burppleShopId;

    @SerializedName("burpple-shop-name")
    private String shopName;

    @SerializedName("burpple-shop-area")
    private String burppleShopArea;

    public String getBurppleShopId() {
        return burppleShopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getBurppleShopArea() {
        return burppleShopArea;
    }
}
