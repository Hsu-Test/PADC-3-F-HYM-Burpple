package xyz.hsuyeemon.burpple.activitites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.fragments.LoginFragment;

/**
 * Created by Dell on 1/26/2018.
 */

public class AccountControlActivity extends AppCompatActivity {

    private static final String IE_SCREEN_TYPE ="IE_SCREEN_TYPE";
    private static final int SCREEN_TYPE_LOGIN=1;
    private static final int SCREEN_TYPE_REGISTER=2;

    public static Intent newIntentLogin(Context context){
        Intent intent = new Intent(context,AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE,SCREEN_TYPE_LOGIN);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_control);
        ButterKnife.bind(this,this);

        int screenType= getIntent().getIntExtra(IE_SCREEN_TYPE,-1);
        if(screenType == SCREEN_TYPE_LOGIN){

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new LoginFragment())
                    .commit();
        }
        /*
        else if(screenType == SCREEN_TYPE_REGISTER){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new RegisterFragment())
                    .commit();
        }
        */



    }
}
