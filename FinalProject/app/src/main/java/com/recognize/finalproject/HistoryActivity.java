package com.recognize.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = "HistoryActivity";
    DatabaseHelper databaseHelper;
    Toolbar toolbarHistory;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    CheckBox chkSelectAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(HistoryActivity.this);

        // ẩn thanh ActionBar đi
        getSupportActionBar().hide();

        // ánh xạ
        toolbarHistory = (Toolbar) findViewById(R.id.toolBarHistory);
        // Chú ý phải để như thế này nếu không menu sẽ không hiển thị (Quan trọng)
        toolbarHistory.inflateMenu(R.menu.menu_history);

        chkSelectAll = (CheckBox) findViewById(R.id.chkSelectAll);
        recyclerView = (RecyclerView) findViewById(R.id.recycleViewHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        myAdapter = new MyAdapter(HistoryActivity.this, getMyListData());
        recyclerView.setAdapter(myAdapter);

        // populateListView();
        addEvents();

    }

    // Lấy tất cả dữ liệu từ Database lên để hiển thị
    private ArrayList<Model> getMyListData() {
        Cursor data = databaseHelper.getData();
        ArrayList<Model> listData = new ArrayList<Model>();
        // Tạm thời set dữ liệu mặc định cho hình ảnh
        Model model = new Model();
        while (data.moveToNext()) {
//            model.setImg(R.drawable.hand_icon);
//            model.setTitle(data.getString(1));
//            model.setDescription("This is news feed description");
            listData.add(new Model(data.getString(1), "This is description", R.drawable.hand_icon));
        }
        return listData;
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        // lấy dữ liệu và thêm vào list
        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            // lấy data từ database của cột 1
            // thêm vào ArrayList
            listData.add(data.getString(1));
        }
        // tạo ListAdapter và set cho nó (mặc định, nếu muốn custom lại cho đẹp)
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        //listView.setAdapter(adapter);

        // sự kiện cho từng Item trong ListView
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String name = adapterView.getItemAtPosition(i).toString();
//                Log.d(TAG, "onItemClick: You Clicked on " + name);
//
//                Cursor data = MainActivity.databaseHelper.getItemID(name); //get the id associated with that name
//                int itemID = -1;
//                while (data.moveToNext()) {
//                    itemID = data.getInt(0);
//                }
//                if (itemID > -1) {
//                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
//                    Intent editScreenIntent = new Intent(HistoryActivity.this, ResultActivity.class);
//                    editScreenIntent.putExtra("id", itemID);
//                    editScreenIntent.putExtra("name", name);
//                    startActivity(editScreenIntent);
//                } else {
//                    toastMessage("No ID associated with that name");
//                }
//            }
//        });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Xử lý sự kiện ở đây
    private void addEvents() {
        // Sự kiện cho nút Back trên thanh Toolbar
        toolbarHistory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Sự kiện chọn tất cả lịch sử
        chkSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }


    // Gắn Menu trên thanh Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    // handle actionbar item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuDelete:
                Toast.makeText(HistoryActivity.this, "Delete Selected", Toast.LENGTH_LONG).show();
            case R.id.mnuSearch:
                Toast.makeText(HistoryActivity.this, "Search Selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

}