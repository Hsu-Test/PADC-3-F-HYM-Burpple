package xyz.hsuyeemon.burpple.networks.responses;

import java.util.List;

import xyz.hsuyeemon.burpple.data.vo.GuideVO;
import xyz.hsuyeemon.burpple.data.vo.PromotionVO;

/**
 * Created by Dell on 1/14/2018.
 */

public class GetGuideResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<GuideVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<GuideVO> getGuides() {
        return featured;
    }
}
