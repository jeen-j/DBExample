package com.creative.jeen.dbexample;

import android.content.Context;

public class ItemData {

    private Context mContext;

    private String mName="";
    private int mRoomNum;
    private String mTel="";

    public ItemData (String name, int roomNum, String tel){
        mName = name;
        mRoomNum = roomNum;
        mTel = tel;
    }

    public String getName() {
        return mName;
    }

    public int getRoomNum() {
        return mRoomNum;
    }

    public String getTel() {
        return mTel;
    }

}
