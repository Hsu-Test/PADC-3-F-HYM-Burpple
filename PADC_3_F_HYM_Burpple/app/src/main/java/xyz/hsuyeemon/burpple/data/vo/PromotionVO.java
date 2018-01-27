package xyz.hsuyeemon.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dell on 1/13/2018.
 */

public class PromotionVO {

    @SerializedName("burpple-promotion-id")
    private String burpplePromotionId;

    @SerializedName("burpple-promotion-image")
    private String burpplePromotionImage;

    @SerializedName("burpple-promotion-title")
    private String burpplePromotionTitle;

    @SerializedName("burpple-promotion-until")
    private String burpplePromotionUntil;

    @SerializedName("burpple-promotion-shop")
    private ShopVO burpplePromotionShop;

    @SerializedName("is-burpple-exclusive")
    private boolean isBurppleExclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> burpplePromotionTerms;

    public String getBurpplePromotionId() {
        return burpplePromotionId;
    }

    public String getBurpplePromotionImage() {
        return burpplePromotionImage;
    }

    public String getBurpplePromotionTitle() {
        return burpplePromotionTitle;
    }

    public String getBurpplePromotionUntil() {
        return burpplePromotionUntil;
    }

    public ShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }

    public boolean isBurppleExclusive() {
        return isBurppleExclusive;
    }

    public List<String> getBurpplePromotionTerms() {
        return burpplePromotionTerms;
    }
}
