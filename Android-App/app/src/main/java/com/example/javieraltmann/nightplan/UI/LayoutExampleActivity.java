package com.example.javieraltmann.nightplan.UI;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.javieraltmann.nightplan.Adapter.ViewPagerAdapter;
import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.R;
import com.example.javieraltmann.nightplan.Services.OnSuccessCallback;
import com.example.javieraltmann.nightplan.Services.RecomendadosClient;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by javier.altmann on 29/11/2017.
 */

public class LayoutExampleActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);


        RecomendadosClient.getDestacados(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {
                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getBaseContext(),(List<Recomendados>) body);

                viewPager.setAdapter(viewPagerAdapter);

            }
        });




      //  dotscount = viewPagerAdapter.getCount();
        dotscount = 4;
        dots = new ImageView[dotscount];


        for (int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            LayoutExampleActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

}
