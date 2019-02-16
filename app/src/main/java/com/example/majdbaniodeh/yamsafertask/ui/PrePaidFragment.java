package com.example.majdbaniodeh.yamsafertask.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.majdbaniodeh.yamsafertask.R;
import com.example.majdbaniodeh.yamsafertask.adapter.ExpandableListAdapter;
import com.example.majdbaniodeh.yamsafertask.model.Accommodation;

import java.util.ArrayList;
import java.util.List;

public class PrePaidFragment extends Fragment {

    private static final String KEY_LIST = "key";
    private ArrayList<Accommodation> prepaidlAccommodation;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;


    public PrePaidFragment() {

    }

    public void setPrepaidlAccommodation(ArrayList<Accommodation> prepaidlAccommodation) {
        this.prepaidlAccommodation = prepaidlAccommodation;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_prepaid, container, false);
        expandableListView = rootView.findViewById(R.id.search_rv);
        if (savedInstanceState != null) {
            prepaidlAccommodation = savedInstanceState.getParcelableArrayList(KEY_LIST);
        }
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                50, r.getDisplayMetrics());
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableListView.setIndicatorBounds(width - px, width);
        } else {
            expandableListView.setIndicatorBoundsRelative(width - px, width);
        }
        init();
        return rootView;
    }

    private void init() {
        List<Accommodation> groupData = prepaidlAccommodation;

        adapter = new ExpandableListAdapter(getContext(), groupData);

        expandableListView.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_LIST, prepaidlAccommodation);
    }
}
