package com.creative.jeen.dbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    EditText mEditText_Name;
    EditText mEditText_RoomNum;
    EditText mEditText_Tel;
    ListAdapter mAdapter;


    ArrayList<ItemData> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataList = new ArrayList<ItemData>();

        //db

        ListView listView = (ListView) findViewById(R.id.listview);
        mAdapter = new ListAdapter(this, mDataList);
        listView.setAdapter(mAdapter);

        Button btnInsert = (Button) findViewById( R.id.btn_insert);
        Button btnModify = (Button) findViewById( R.id.btn_modify);
        Button btnDelete = (Button) findViewById( R.id.btn_delete);

        btnInsert.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        mEditText_Name = (EditText) findViewById( R.id.et_name );
        mEditText_RoomNum = (EditText) findViewById( R.id.et_roomnum );
        mEditText_Tel = (EditText) findViewById( R.id.et_tel );

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_insert:

                break;
            case R.id.btn_modify:
                break;
            case R.id.btn_delete:
                break;
        }
    }

}
