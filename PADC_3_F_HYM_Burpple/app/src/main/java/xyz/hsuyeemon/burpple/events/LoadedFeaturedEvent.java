package xyz.hsuyeemon.burpple.events;

import java.util.ArrayList;
import java.util.List;

import xyz.hsuyeemon.burpple.data.vo.FeaturedVO;

/**
 * Created by Dell on 1/14/2018.
 */

public class LoadedFeaturedEvent {

    private List<FeaturedVO> featuredList;

    public LoadedFeaturedEvent(List<FeaturedVO> featuredList){
            this.featuredList = featuredList;
    }

    public List<FeaturedVO> getFeaturedList() {
        return featuredList;
    }
}
