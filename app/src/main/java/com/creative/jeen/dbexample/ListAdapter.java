package com.creative.jeen.dbexample;


import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<ItemData> mDataList;


    ListAdapter(Context context, ArrayList<ItemData> dataList) {

        mContext = context;
        mDataList = dataList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list, parent, false);
        }


        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvRoomNum = (TextView) convertView.findViewById(R.id.tv_room_num);
        TextView tvTel = (TextView) convertView.findViewById(R.id.tv_tel);

        tvName.setText(mDataList.get(position).getName());
        tvName.setText(mDataList.get(position).getRoomNum());
        tvName.setText(mDataList.get(position).getTel());

        return convertView;

    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
