package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private static final String TAG="MainActivity";
private Context mContext;
ArrayList<String> titleArrayList;
private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        titleArrayList =new ArrayList<String>();
        titleArrayList.add(Constants.WHAT_IS_JAVA);
        titleArrayList.add(Constants.HISTORY_OF_JAVA);
        titleArrayList.add(Constants.FEATURES_OF_JAVA);
        titleArrayList.add(Constants.C_VS_JAVA);
        titleArrayList.add(Constants.HELLO_JAVA_PROGRAM);
        titleArrayList.add(Constants.PROGRAM_INTERNAL);
        titleArrayList.add(Constants.HOW_TO_SET_PATH);
        titleArrayList.add(Constants.JDK_JRE_AND_JVM);
        titleArrayList.add(Constants.INTERNAL_DETAIL_OF_JVM);
        titleArrayList.add(Constants.JAVA_VARIABLES);
        titleArrayList.add(Constants.JAVA_DATA_TYPES);
        titleArrayList.add(Constants.UNICODE_SYSTEM);
        titleArrayList.add(Constants.OPERATORS);



        mRecyclerView=(RecyclerView/*typecasting_*/)findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TitleAdapter adapter=new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(mContext,"clicked"+titleArrayList.get(position),Toast.LENGTH_SHORT).show();
                Intent desIntent=new Intent(MainActivity.this,DescriptionActivity.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);
            }
        });
mRecyclerView.setAdapter(adapter);
    }
}
