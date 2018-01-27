package xyz.hsuyeemon.burpple.data.models;

import xyz.hsuyeemon.burpple.networks.dataagents.BurppleFoodPlaceDataAgent;
import xyz.hsuyeemon.burpple.networks.dataagents.FeaturedOkHttpDataAgent;
import xyz.hsuyeemon.burpple.networks.dataagents.RetrofitDataAgent;

/**
 * Created by Dell on 1/14/2018.
 */

public class FeaturedModel {

    private static FeaturedModel sfeatured;
    private BurppleFoodPlaceDataAgent mDataAgent;

    private FeaturedModel(){
       // mDataAgent= FeaturedOkHttpDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static FeaturedModel getObjInstance(){
        if(sfeatured == null ){
            sfeatured = new FeaturedModel();
        }
        return sfeatured;
    }

    public void loadFeatured(){
        mDataAgent.loadFeatured();
    }


}
