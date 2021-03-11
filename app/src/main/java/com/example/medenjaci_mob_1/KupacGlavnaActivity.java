package com.example.medenjaci_mob_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KupacGlavnaActivity extends AppCompatActivity {

    ViewPager mSlideViewPager;
    LinearLayout mDotsLayout;

    TextView[] mDots;

    SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kupac_glavna);

        // action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_with_menu_layout);

        mSlideViewPager = (ViewPager)findViewById(R.id.sliderViewPager);
        mDotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotIndicator(int position){

        mDots = new TextView[4];
        mDotsLayout.removeAllViews();
        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);

            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(70);
            mDots[i].setTextColor(getResources().getColor(R.color.black));

            mDotsLayout.addView(mDots[i]);
        }

        if(mDots.length > 0 ){
            mDots[position].setTextColor(getResources().getColor(R.color.yellow_100));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}