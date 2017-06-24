package com.example.compiler.qxcgame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import com.example.compiler.qxcgame.FragmentV4.ExtractFragment;
import com.example.compiler.qxcgame.FragmentV4.AnalyticFragment;
import com.example.compiler.qxcgame.FragmentV4.PortfolioFragment;


//https://github.com/compilerxx/QXCgame.git

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> fragments;

    private LinearLayout mTabExtract;
    private LinearLayout mTabAnalytic;
    private LinearLayout mTabPortfolio;

    private ImageButton mExtract;
    private ImageButton mAnalytic;
    private ImageButton mPortfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
    }

    private void initEvent() {
        mExtract.setOnClickListener(this);
        mAnalytic.setOnClickListener(this);
        mPortfolio.setOnClickListener(this);

    }

    private void initView() {
        //初始化
        viewPager= (ViewPager) findViewById(R.id.id_viewpager3);
        mTabExtract= (LinearLayout) findViewById(R.id.id_tab_extract);
        mTabAnalytic= (LinearLayout) findViewById(R.id.id_tab_analytic);
        mTabPortfolio= (LinearLayout) findViewById(R.id.id_tab_portfolio);


        mExtract= (ImageButton) findViewById(R.id.id_tab_extract_img);
        mAnalytic= (ImageButton) findViewById(R.id.id_tab_analytic_img);
        mPortfolio= (ImageButton) findViewById(R.id.id_tab_portfolio_img);

        fragments=new ArrayList<>();

        ExtractFragment extractFragment = new ExtractFragment();
        AnalyticFragment analyticFragment = new AnalyticFragment();
        PortfolioFragment portfolioFragment = new PortfolioFragment();


        fragments.add(extractFragment);
        fragments.add(analyticFragment);
        fragments.add(portfolioFragment);

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(mAdapter);
        // viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        // setOnPageChangeListener deprecated
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImage();
                switch (position){
                    case 0:
                        mExtract.setImageResource(R.drawable.data_extract1);
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        mAnalytic.setImageResource(R.drawable.data_analytic1);
                        viewPager.setCurrentItem(1);
                        break;
                    case 2:
                        mPortfolio.setImageResource(R.drawable.my_portfolio1);
                        viewPager.setCurrentItem(2);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        resetImage();
        switch (view.getId()) {
            case R.id.id_tab_extract_img:
                setSelect(0);
                break;
            case R.id.id_tab_analytic_img:
                setSelect(1);
                break;
            case R.id.id_tab_portfolio_img:
                setSelect(2);
                break;

        }
    }

    public void setSelect(int select) {

        switch (select){
            case 0:
                mExtract.setImageResource(R.drawable.data_extract1);
                viewPager.setCurrentItem(0);
                break;
            case 1:
                mAnalytic.setImageResource(R.drawable.data_analytic1);
                viewPager.setCurrentItem(1);
                break;
            case 2:
                mPortfolio.setImageResource(R.drawable.my_portfolio1);
                viewPager.setCurrentItem(2);
                break;

        }
    }

    private void resetImage() {

        mExtract.setImageResource(R.drawable.data_extract0);
        mAnalytic.setImageResource(R.drawable.data_analytic0);
        mPortfolio.setImageResource(R.drawable.my_portfolio0);
    }





}
