package com.example.majdbaniodeh.yamsafertask.ui;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.majdbaniodeh.yamsafertask.R;
import com.example.majdbaniodeh.yamsafertask.adapter.ViewPagerAdapter;
import com.example.majdbaniodeh.yamsafertask.model.Accommodation;
import com.example.majdbaniodeh.yamsafertask.viewmodel.DataViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Accommodation> atHotelAccommodation;
    private ArrayList<Accommodation> prepaidlAccommodation;
    private PaidAtHotelFragment paidAtHotelFragment;
    private PrePaidFragment prePaidFragment;
    private ViewPagerAdapter adapter;


    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager1);
        setUpViewModel();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);


    }

    private void setupViewPager(ViewPager viewPager) {
        paidAtHotelFragment = new PaidAtHotelFragment();
        prePaidFragment = new PrePaidFragment();
        paidAtHotelFragment.setAtHotelAccommodation(atHotelAccommodation);
        prePaidFragment.setPrepaidlAccommodation(prepaidlAccommodation);

        adapter.addFragment(paidAtHotelFragment, "pay at hotel");
        adapter.addFragment(prePaidFragment, "pre-paid");
        viewPager.setAdapter(adapter);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }


    }

    private void setUpViewModel() {
        DataViewModel viewModel = new DataViewModel();
        viewModel.getDataObservable().observe(this, new Observer<ArrayList<Accommodation>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Accommodation> accommodationArrayList) {
                splitResult(accommodationArrayList);

            }
        });

    }

    private void splitResult(ArrayList<Accommodation> results) {
        atHotelAccommodation = new ArrayList<>();
        prepaidlAccommodation = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).getRatesList().size(); j++) {
                if (results.get(i).getRatesList().get(j).isPrepaid()) {
                    if (!prepaidlAccommodation.contains(results.get(i))) {
                        prepaidlAccommodation.add(results.get(i));
                    }

                } else {

                    if (!atHotelAccommodation.contains(results.get(i))) {
                        atHotelAccommodation.add(results.get(i));
                    }

                }

            }
        }

        updateUi();

    }

    private void updateUi() {
        setupViewPager(viewPager);


    }


}
