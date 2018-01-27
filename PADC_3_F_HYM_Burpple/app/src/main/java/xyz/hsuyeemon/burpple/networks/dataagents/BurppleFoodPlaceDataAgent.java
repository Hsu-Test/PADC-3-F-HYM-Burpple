package xyz.hsuyeemon.burpple.networks.dataagents;

/**
 * Created by Dell on 1/14/2018.
 */

public interface BurppleFoodPlaceDataAgent {

    void loadFeatured();

    void loadGuides();

    void loadPromotion();

    void loginUser(String phoneNo,String password);

}
