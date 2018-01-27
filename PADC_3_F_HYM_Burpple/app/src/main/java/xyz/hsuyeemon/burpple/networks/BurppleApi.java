package xyz.hsuyeemon.burpple.networks;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.hsuyeemon.burpple.networks.responses.GetFeaturedResponse;
import xyz.hsuyeemon.burpple.networks.responses.GetGuideResponse;
import xyz.hsuyeemon.burpple.networks.responses.GetLoginUserResponse;
import xyz.hsuyeemon.burpple.networks.responses.GetPromotionResponse;

/**
 * Created by Dell on 1/14/2018.
 */

public interface BurppleApi {

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetFeaturedResponse> loadFeatured(@Field("page") int page,
                                           @Field("access_token") String accessToken);


    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponse> loadPromotion(@Field("page") int page,
                                             @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetGuideResponse> loadGuide(@Field("page") int page,
                                     @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<GetLoginUserResponse> loginUser(@Field("phoneNo") String phoneNo,
                                         @Field("password") String password);

}
