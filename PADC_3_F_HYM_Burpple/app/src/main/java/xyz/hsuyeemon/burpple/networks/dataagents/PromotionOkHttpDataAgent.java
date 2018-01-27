package xyz.hsuyeemon.burpple.networks.dataagents;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.hsuyeemon.burpple.BurppleApp;
import xyz.hsuyeemon.burpple.events.LoadedPromotionEvent;
import xyz.hsuyeemon.burpple.networks.responses.GetPromotionResponse;

/**
 * Created by Dell on 1/12/2018.
 */

public class PromotionOkHttpDataAgent implements BurppleFoodPlaceDataAgent {

    private static BurppleFoodPlaceDataAgent objInstance;
    private PromotionOkHttpDataAgent(){

    }
    public static BurppleFoodPlaceDataAgent getObjInstance(){
        if(objInstance==null){
            objInstance=new PromotionOkHttpDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadFeatured() {

    }

    @Override
    public void loadGuides() {

    }

    @Override
    public void loadPromotion() {

        new LoadTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getPromotions.php");
    }

    @Override
    public void loginUser(String phoneNo, String password) {

    }


    public static class LoadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String url=urls[0];

            OkHttpClient httpClient= new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();
            RequestBody formBody= new FormBody.Builder()
                    .add("access_token","b002c7e1a528b7cb460933fc2875e916")
                    .add("page","1")
                    .build();

            Request request =new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;
            try{
                Response response=httpClient.newCall(request).execute();
                if(response.isSuccessful() && response.body() != null){
                    responseString = response.body().string();
                }

            } catch (Exception e) {
                Log.e(BurppleApp.LOG_TAG,e.getMessage());
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            //change string to object
            Gson gson = new Gson();
            GetPromotionResponse getPromotionResponse=gson.fromJson(response,GetPromotionResponse.class);

            LoadedPromotionEvent event= new LoadedPromotionEvent(getPromotionResponse.getPromotion());
            EventBus.getDefault().post(event);

        }
    }
}
