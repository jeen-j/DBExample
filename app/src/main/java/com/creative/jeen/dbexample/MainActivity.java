package com.creative.jeen.dbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.creative.db.dbexample.DBContract;
import com.creative.db.dbexample.DBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    SQLiteDatabase mDb;
    EditText mEditText_Name;
    EditText mEditText_RoomNum;
    EditText mEditText_Tel;
    ListAdapter mAdapter;


    ArrayList<ItemData> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this, DBContract.DBEntry.TABLE_NAME, null, 1);
        mDb = dbHelper.getWritableDatabase();

        mDataList = new ArrayList<ItemData>();

        doWhileCursorToArray();

        ListView listView = (ListView) findViewById(R.id.listview);
        mAdapter = new ListAdapter(this, mDataList);
        listView.setAdapter(mAdapter);

        Button btnInsert = (Button) findViewById( R.id.btn_insert);
        btnInsert.setOnClickListener(this);

        mEditText_Name = (EditText) findViewById( R.id.et_name );
        mEditText_RoomNum = (EditText) findViewById( R.id.et_roomnum );
        mEditText_Tel = (EditText) findViewById( R.id.et_tel );

    }

    @Override
    public void onClick(View view) {

        if( view.getId() == R.id.btn_insert){
            String name = mEditText_Name.getText().toString();
            String roomNum= mEditText_RoomNum.getText().toString();
            String tel = mEditText_Tel.getText().toString();

            ContentValues row = new ContentValues();

            row.put(DBContract.DBEntry.COLUMN_NAME_NAME, name);
            row.put(DBContract.DBEntry.COLUMN_NAME_ROOM_NUMBER, roomNum);
            row.put(DBContract.DBEntry.COLUMN_NAME_TEL, tel);

            mDb.insert(DBContract.DBEntry.TABLE_NAME, null, row);

            mDataList.clear();
            doWhileCursorToArray();
            mAdapter.notifyDataSetChanged();

        }

    }

    public void doWhileCursorToArray(){
        DBHelper dbHelper = new DBHelper(this, DBContract.DBEntry.TABLE_NAME, null, 1);
        mDb = dbHelper.getWritableDatabase();


        Cursor cursor = mDb.query(DBContract.DBEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);



        while (cursor.moveToNext()) {


            ItemData data = new ItemData(
                    cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_NAME)),
                    cursor.getInt(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_ROOM_NUMBER)),
                    cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_TEL)));

            mDataList.add(data);
        }

        cursor.close();


    }
}
