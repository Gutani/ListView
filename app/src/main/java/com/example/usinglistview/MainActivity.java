package com.example.usinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity<replace> extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    private String[] items = {"China", "USA", "England", "Japan", "Brazil", "France", "Portugal", "Norway",
            "Sweden", "Russia", "Saudi Arabia", "Canada", "Mexico", "Spain", "Germany", "Argentina" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.listView = findViewById(R.id.listView);
        //Sort the array in alphabetical order
        Arrays.sort(items, String.CASE_INSENSITIVE_ORDER);
        //Creating an adapter to list view, because it can variate ex.: strings, doubles, dates, etc
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.test_list_item, android.R.id.text1, items);
        mViewHolder.listView.setAdapter(adapter);
        //Adding click on list
        mViewHolder.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = mViewHolder.listView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, selectedValue, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class ViewHolder{
        ListView listView;
    }
}