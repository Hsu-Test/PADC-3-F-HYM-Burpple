package xyz.hsuyeemon.burpple.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.hsuyeemon.burpple.BurppleApp;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.data.models.LoginUserModel;
import xyz.hsuyeemon.burpple.events.SuccessLoginEvent;
import xyz.hsuyeemon.burpple.networks.BurppleApi;

/**
 * Created by Dell on 1/26/2018.
 */

public class LoginFragment  extends Fragment {

    @BindView(R.id.et_mobile_or_email)
    EditText etMobileOrEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view){
        String phoneNo = etMobileOrEmail.getText().toString();
        String password = etPassword.getText().toString();
        LoginUserModel.getObjectInstance().loginUser(phoneNo,password);
     /*   Snackbar.make(view, "Replace with your own action - Butterknife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

*/
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessLogin(SuccessLoginEvent event){
       if(getActivity()!= null){
            getActivity().onBackPressed();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
