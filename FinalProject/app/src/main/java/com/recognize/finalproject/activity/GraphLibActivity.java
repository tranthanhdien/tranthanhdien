package com.recognize.finalproject.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.recognize.finalproject.R;
import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;

public class GraphLibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_lib);

        Function xSquared = new Function()
        {
            public double apply(double x)
            {
                return x*x - x - 2;
            }
        };
        // ban đầu khi add thư viện sẽ bị lỗi
        // solution: xóa file module.xml trong thư mục .idea của app
        Graph graph = new Graph.Builder()
                .addFunction(xSquared)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Đồ thị hàm số");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Đồ thị hàm số");
    }
}