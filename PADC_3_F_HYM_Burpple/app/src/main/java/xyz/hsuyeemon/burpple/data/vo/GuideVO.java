package xyz.hsuyeemon.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 1/13/2018.
 */

public class GuideVO {

    @SerializedName("burpple-guide-id")
    private String burppleGuideId;

    @SerializedName("burpple-guide-image")
    private String burppleGuideImage;

    @SerializedName("burpple-guide-title")
    private String burppleGuideTitle;

    @SerializedName("burpple-guide-desc")
    private String burppleGuideDesc;

    public String getBurppleGuideId() {
        return burppleGuideId;
    }

    public String getBurppleGuideImage() {
        return burppleGuideImage;
    }

    public String getBurppleGuideTitle() {
        return burppleGuideTitle;
    }

    public String getBurppleGuideDesc() {
        return burppleGuideDesc;
    }
}
