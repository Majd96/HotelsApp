package com.example.majdbaniodeh.yamsafertask.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.majdbaniodeh.yamsafertask.R;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;

    public ViewPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


    public View getTabView(int position) {
        int tabTitles[] = new int[]{R.string.tab_0, R.string.tab_1};
        int rateTitles[] = new int[]{R.string.tab_rate0, R.string.tab_rate1};
        int drawables[] = new int[]{R.drawable.rounded_corner0, R.drawable.rounded_corners1};
        int colors[] = new int[]{R.color.color_tab0, R.color.color_tab1};
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView title = v.findViewById(R.id.tab_title);
        title.setBackground(context.getResources().getDrawable(drawables[position]));
        title.setText(context.getString(tabTitles[position]));
        title.setTextColor(context.getResources().getColor(colors[position]));
        title.setPadding(30, 2, 30, 2);
        TextView rateTitle = v.findViewById(R.id.rateInfo);
        rateTitle.setText(context.getString(rateTitles[position]));

        return v;
    }
}

