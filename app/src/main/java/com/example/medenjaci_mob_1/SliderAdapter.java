package com.example.medenjaci_mob_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.nio.InvalidMarkException;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slike = {
            R.drawable.cvetni,
            R.drawable.med1,
            R.drawable.med_sace,
            R.drawable.medovaca
    };

    public String[] nazivi = {
            "Cvetni med",
            "Bagremov med",
            "Med u sacu",
            "Medovaca"
    };

    public String[] cene = {
            "500 din",
            "750 din",
            "1100 din",
            "950 din"
    };

    @Override
    public int getCount() {
        return nazivi.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slikaProizvoda);
        TextView nazivView = (TextView) view.findViewById(R.id.imeProizvoda);
        TextView cenaView  = (TextView) view.findViewById(R.id.cenaProizvoda);

        imageView.setImageResource(slike[position]);
        nazivView.setText(nazivi[position]);
        cenaView.setText(cene[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
