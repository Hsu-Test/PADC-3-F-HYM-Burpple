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
import xyz.hsuyeemon.burpple.events.LoadedGuideEvent;
import xyz.hsuyeemon.burpple.networks.responses.GetGuideResponse;

/**
 * Created by Dell on 1/13/2018.
 */

public class GuideOkHttpDataAgent implements BurppleFoodPlaceDataAgent{

    private static BurppleFoodPlaceDataAgent sDataAgent;
    private GuideOkHttpDataAgent(){

    }
    public static BurppleFoodPlaceDataAgent getObjInstance(){
        if(sDataAgent==null){
            sDataAgent= new GuideOkHttpDataAgent();
        }
        return sDataAgent;
    }

    @Override
    public void loadFeatured() {

    }

    @Override
    public void loadGuides() {
        new LoadGuideTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");

    }

    @Override
    public void loadPromotion() {

    }

    @Override
    public void loginUser(String phoneNo, String password) {

    }


    public static class LoadGuideTask extends AsyncTask<String,Void,String>{


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
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            GetGuideResponse getGuideResponse=gson.fromJson(s,GetGuideResponse.class);

            LoadedGuideEvent event=new LoadedGuideEvent(getGuideResponse.getGuides());
            EventBus.getDefault().post(event);
        }
    }





}
