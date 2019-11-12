package com.creative.jeen.dbexample;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<ItemData> mDataList;


    ListAdapter(Context context, ArrayList<ItemData> dataList) {

        mContext = context;


        mDataList = new ArrayList<ItemData>();


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list, parent, false);
        }

        final String name = mDataList.get(position).getName();
        final String roomNum = Integer.toString( mDataList.get(position).getRoomNum());
        final String tel = mDataList.get(position).getTel();

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvRoomNum = (TextView) convertView.findViewById(R.id.tv_room_num);
        TextView tvTel = (TextView) convertView.findViewById(R.id.tv_tel);

        tvName.setText(name);
        tvRoomNum.setText(roomNum);
        tvTel.setText(tel);

        Button btnDelete = (Button) convertView.findViewById(R.id.btn_delete);
        Button btnModify = (Button) convertView.findViewById(R.id.btn_modify);

        final int item_position = position;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


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
