package com.example.u.realapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by U on 5/4/2017.
 */

public class ImageSliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] Images1 = {R.drawable.mt,R.drawable.life,R.drawable.vishal};

    public ImageSliderAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return Images1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_slider_custom_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewSlider);
        imageView.setImageResource(Images1[position]);
        ViewPager vp = (ViewPager)container;
        vp.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }
}
