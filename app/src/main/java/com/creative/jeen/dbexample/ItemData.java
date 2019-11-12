package com.creative.jeen.dbexample;

import android.content.Context;

public class ItemData {

    private Context mContext;

    private String mName="";
    private int mRoomNum;
    private String mTel="";
    private int mId;

    public ItemData (int id, String name, int roomNum, String tel){
        mId = id;
        mName = name;
        mRoomNum = roomNum;
        mTel = tel;
    }

    public int getId() {
        return mId;
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
