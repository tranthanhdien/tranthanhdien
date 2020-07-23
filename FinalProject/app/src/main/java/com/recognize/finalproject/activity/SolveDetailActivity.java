package com.recognize.finalproject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.recognize.finalproject.R;
import com.recognize.finalproject.adapter.SolveDetailAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolveDetailActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroups;
    HashMap<String, List<String>> listItems;
    SolveDetailAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_detail);

        getSupportActionBar().hide();
        addControls();
        addEvents();
        listGroups = new ArrayList<>();
        listItems = new HashMap<>();
        adapter = new SolveDetailAdapter(this, listGroups, listItems);
        expandableListView.setAdapter(adapter);
        initListData();


    }

    private void addEvents() {
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.toolBarSolveDetail);
        toolbar.setTitle("Hướng dẫn giải chi tiết");
        expandableListView = findViewById(R.id.expandable_listView);
    }

    private void initListData() {
        listGroups.add(getString(R.string.group1));
        listGroups.add(getString(R.string.group2));
        listGroups.add(getString(R.string.group3));
        listGroups.add(getString(R.string.group4));
        listGroups.add(getString(R.string.group5));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group1);
        for (String item: array) {
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group2);
        for (String item: array) {
            list2.add(item);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group3);
        for (String item: array) {
            list3.add(item);
        }

        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group4);
        for (String item: array) {
            list4.add(item);
        }

        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group5);
        for (String item: array) {
            list5.add(item);
        }

        listItems.put(listGroups.get(0), list1);
        listItems.put(listGroups.get(1), list2);
        listItems.put(listGroups.get(2), list3);
        listItems.put(listGroups.get(3), list4);
        listItems.put(listGroups.get(4), list5);
        adapter.notifyDataSetChanged();

    }
}