package xyz.hsuyeemon.burpple.activitites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.hsuyeemon.burpple.BurppleApp;
import xyz.hsuyeemon.burpple.R;
import xyz.hsuyeemon.burpple.adapters.BurppleGuideAdapter;
import xyz.hsuyeemon.burpple.adapters.FoodHighlightAdapter;
import xyz.hsuyeemon.burpple.adapters.NewlyOpenedShopAdapter;
import xyz.hsuyeemon.burpple.adapters.PromotionAdapter;
import xyz.hsuyeemon.burpple.adapters.TrendingVenuesAdapter;
import xyz.hsuyeemon.burpple.data.models.FeaturedModel;
import xyz.hsuyeemon.burpple.data.models.GuideModel;
import xyz.hsuyeemon.burpple.data.models.LoginUserModel;
import xyz.hsuyeemon.burpple.data.models.PromotionModel;
import xyz.hsuyeemon.burpple.delegates.BeforeLoginUserDelegate;
import xyz.hsuyeemon.burpple.delegates.LoginUserDelegate;
import xyz.hsuyeemon.burpple.events.LoadedFeaturedEvent;
import xyz.hsuyeemon.burpple.events.LoadedGuideEvent;
import xyz.hsuyeemon.burpple.events.LoadedPromotionEvent;
import xyz.hsuyeemon.burpple.viewpods.AccountControlViewPod;
import xyz.hsuyeemon.burpple.viewpods.BeforeLoginViewPod;

public class MainActivity extends AppCompatActivity implements BeforeLoginUserDelegate,LoginUserDelegate{

    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

    @BindView(R.id.vp_food_highlight)
    ViewPager vpFoodHighlight;

    @BindView(R.id.rv_bupple_guides)
    RecyclerView rvBurppleGuides;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvTrendingVenues;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private PromotionAdapter mPromotionAdapter;
    private FoodHighlightAdapter mFoodHighlightAdapter;
    private BurppleGuideAdapter mBurppleGuideAdapter;
    private NewlyOpenedShopAdapter mNewlyOpenedShopAdapter;
    private TrendingVenuesAdapter mTrendingVenuesAdapter;


    private AccountControlViewPod vpAccountControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Home");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        }


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvPromotions.setLayoutManager(linearLayoutManager);
        mPromotionAdapter=new PromotionAdapter();
        rvPromotions.setAdapter(mPromotionAdapter);

        mFoodHighlightAdapter=new FoodHighlightAdapter();
        vpFoodHighlight.setAdapter(mFoodHighlightAdapter);

        LinearLayoutManager burppleGuideslinearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvBurppleGuides.setLayoutManager(burppleGuideslinearLayoutManager);
        mBurppleGuideAdapter=new BurppleGuideAdapter();
        rvBurppleGuides.setAdapter(mBurppleGuideAdapter);

        LinearLayoutManager newlyOpenedlinearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvNewlyOpened.setLayoutManager(newlyOpenedlinearLayoutManager);
        mNewlyOpenedShopAdapter=new NewlyOpenedShopAdapter();
        rvNewlyOpened.setAdapter(mNewlyOpenedShopAdapter);

        LinearLayoutManager trendingVenuesLinearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvTrendingVenues.setLayoutManager(trendingVenuesLinearLayoutManager);
        mTrendingVenuesAdapter=new TrendingVenuesAdapter();
        rvTrendingVenues.setAdapter(mTrendingVenuesAdapter);

/*
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return false;
            }
        });*/

        FeaturedModel.getObjInstance().loadFeatured();
        PromotionModel.getObjInstance().loadPromotion();
        GuideModel.getObjInstance().loadGuides();

        vpAccountControl = (AccountControlViewPod) navigationView.getHeaderView(0);
        vpAccountControl.setDelegate((BeforeLoginUserDelegate) this);
        vpAccountControl.setDelegate((LoginUserDelegate)this);


    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * event listen
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadedPromotionEvent event){
        Log.d(BurppleApp.LOG_TAG,"onPromotionLoaded"+event.getPromotionList().size());
        mPromotionAdapter.setPromotion(event.getPromotionList());

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuideLoaded(LoadedGuideEvent event){
        Log.d(BurppleApp.LOG_TAG,"onGuidedLoaded"+event.getGuideList().size());
        mBurppleGuideAdapter.setGuides(event.getGuideList());
    }


    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onFeaturedLoaded(LoadedFeaturedEvent event){
        Log.d(BurppleApp.LOG_TAG, "onFeaturedLoaded" + event.getFeaturedList().size());
        mFoodHighlightAdapter.setFeatures(event.getFeaturedList());
    }


    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {

    }

    @Override
    public void onTapLogout() {
        LoginUserModel.getObjectInstance().logout();
    }
}
