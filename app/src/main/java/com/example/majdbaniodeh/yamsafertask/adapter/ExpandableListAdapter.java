package com.example.majdbaniodeh.yamsafertask.adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.majdbaniodeh.yamsafertask.R;
import com.example.majdbaniodeh.yamsafertask.model.Accommodation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = ExpandableListAdapter.class.getName();
    private Context mContext;
    private List<Accommodation> mListData;

    public ExpandableListAdapter(Context mContext, List<Accommodation> mListData) {
        this.mContext = mContext;
        this.mListData = mListData;

    }


    @Override
    public int getGroupCount() {
        return mListData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return mListData.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListData.get(groupPosition).getRatesList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupId) {
        return groupId;
    }

    @Override
    public long getChildId(int groupId, int childId) {
        return childId;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {

        ImageView imageView;
        TextView nameTextView;
        TextView rateTextView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_group, null);
        }

        // Fetching the view and binding the appropriate text to it
        imageView = convertView.findViewById(R.id.image_accommodation);
        nameTextView = convertView.findViewById(R.id.textViewName);
        rateTextView = convertView.findViewById(R.id.textViewRate);

        try {
            Picasso.get().load(mListData.get(i).getImages().get(0)).into(imageView);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
        rateTextView.setText(mListData.get(i).getRatesList().size() + " " + mContext.getString(R.string.rate_message));
        nameTextView.setText(mListData.get(i).getName());

        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {

        ImageView imageViewChild;
        TextView nameTextViewChild;
        RecyclerView recyclerView;


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_child, null);
        }
        imageViewChild = convertView.findViewById(R.id.imageViewChild);
        nameTextViewChild = convertView.findViewById(R.id.textViewNameChild);
        recyclerView = convertView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        try {
            Picasso.get().load(mListData.get(i).getImages().get(0)).into(imageViewChild);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
        nameTextViewChild.setText(mListData.get(i).getName());
        recyclerView.setAdapter(new RateAdapter(mListData.get(i).getRatesList(), mContext));


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
