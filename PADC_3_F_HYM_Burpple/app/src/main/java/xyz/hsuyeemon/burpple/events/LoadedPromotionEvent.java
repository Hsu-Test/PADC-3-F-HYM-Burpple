package xyz.hsuyeemon.burpple.events;

import java.util.List;

import xyz.hsuyeemon.burpple.data.vo.PromotionVO;


/**
 * Created by Dell on 1/13/2018.
 */

public class LoadedPromotionEvent {

    private List<PromotionVO> promotionList;
    public LoadedPromotionEvent(List<PromotionVO> promotionList){
        this.promotionList=promotionList;
    }

    public List<PromotionVO> getPromotionList() {
        return promotionList;
    }
}
