package xyz.hsuyeemon.burpple.networks.responses;

import java.util.List;

import xyz.hsuyeemon.burpple.data.vo.FeaturedVO;
import xyz.hsuyeemon.burpple.data.vo.GuideVO;

/**
 * Created by Dell on 1/14/2018.
 */

public class GetFeaturedResponse {

    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<FeaturedVO> featured;

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

    public List<FeaturedVO> getFeatureds() {
        return featured;
    }


}
