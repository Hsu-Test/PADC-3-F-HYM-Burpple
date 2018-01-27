package xyz.hsuyeemon.burpple.events;

import java.util.List;

import xyz.hsuyeemon.burpple.data.vo.GuideVO;

/**
 * Created by Dell on 1/14/2018.
 */

public class LoadedGuideEvent {

    private List<GuideVO> guideList;
    public LoadedGuideEvent(List<GuideVO> guideList){
        this.guideList=guideList;
    }

    public List<GuideVO> getGuideList() {
        return guideList;
    }
}
