package com.recognize.finalproject.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.recognize.finalproject.R;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;

public class GraphViewActivity extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series1, series2;
    Toolbar toolbar;
    GraphView graphView;
    TextView txtGraph, txtDongBien;
//    int heSoA, heSoB; // hệ số a, b và phép (+, -) của pt: y = ax + b
//    char operator;
//    int x1 = -3;
//    int x2 = -2;
//    int x3 = -1;
//    int x4 = 0;
//    int x5 = 1;
//    int x6 = 2;
//    int x7 = 3;

    String graph; // data lấy từ Intent ResultActivity gửi qua

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view);

        //getSupportActionBar().hide(); // ẩn thanh ActionBar đi
        addControls();
        addDataIntent();
        addEvents();
        drawGraph();
    }
    // ban đầu khi add thư viện sẽ bị lỗi
    // solution: xóa file module.xml trong thư mục .idea của app
    private void drawGraph() {
        Function xSquared = new Function()
        {
            public double apply(double x) {
                double result = 0;
                try {
                    // y = a x + b
//                    char a = graph.charAt(4); // hệ số a của pt: y = ax + b
//                    char b = graph.charAt(10); // hệ số b của pt: y = ax + b
//                    int heSoA = Integer.parseInt(String.valueOf(a));
//                    int heSoB = Integer.parseInt(String.valueOf(b));
//                    char operator = graph.charAt(8); // toán tử + or - của pt: y = ax + b
//                    if (graph.charAt(6) == 'x') {
//                        result = (operator == '+' ? ((heSoA * x) + heSoB) : ((heSoA * x) - heSoB));
//                    }
                    result = x*x*x + 3*x*x - 4;
                    // y = ax^2 + bx + c
//                    if (graph.contains("y = x2")) {
//                        result = x*x;
//                    }
                } catch (Exception e) {
                    FancyToast.makeText(GraphViewActivity.this,"Đồ thị không đúng định dạng!",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
                    return result;
                }
        };
        Graph graph = new Graph.Builder().
                addFunction(xSquared, Color.RED).
                build();
        graphView.setGraph(graph);
    }

    private void addDataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("graph")) {
                // đầu tiên lấy dữ liệu Intent gửi qua
                graph = intent.getStringExtra("graph");
                // set text cho phương trình
                txtGraph.setText("Hàm số: " + graph.toString());
//                // kiểm tra độ dài của phương trình: y = ax + b
//                if (graph.length() == 10) {
//                    try {
//                        // tách thành các ký tự để lấy các tham số a, b
//                        char a = graph.charAt(4); // hệ số a của pt: y = ax + b
//                        char b = graph.charAt(9); // hệ số b của pt: y = ax + b
//                        operator = graph.charAt(7); // toán tử + or - của pt: y = ax + b
//                        //Toast.makeText(GraphViewActivity.this, heSoA + " " + operator + " " + heSoB, Toast.LENGTH_LONG).show();
//                        // phải chuyển kiểu char thành int, nếu không sẽ ra kết quả không đúng
//                        heSoA = Integer.parseInt(String.valueOf(a));
//                        heSoB = Integer.parseInt(String.valueOf(b));
//                        if (heSoA > 0) {
//                            txtDongBien.setText("Hàm số đồng biến trên R");
//                        } else {
//                            txtDongBien.setText("Hàm số nghịch biến trên R");
//                        }
//
//                    } catch (Exception e) {
//                        //Toast.makeText(GraphViewActivity.this, "Vui lòng thử lại!", Toast.LENGTH_LONG).show();
//                    }
//                }
//                // kiểm tra độ dài của phương trình: y = a x + b
//                if (graph.length() == 11) {
//                    char sign = graph.charAt(4);
//                    // tiếp theo kiểm tra hệ số a có âm không
//                    if (sign == '-') {
//                        // tách thành các ký tự để lấy các tham số a, b
//                        char a = graph.charAt(5); // hệ số b của pt: y = ax + b
//                        char b = graph.charAt(10); // hệ số b của pt: y = ax + b
//                        operator = graph.charAt(8); // hệ số b của pt: y = ax + b
//                        //Toast.makeText(GraphViewActivity.this, heSoA + " " + operator + " " + heSoB, Toast.LENGTH_LONG).show();
//                        // phải chuyển kiểu char thành int, nếu không sẽ ra kết quả không đúng
//                        heSoA = -(Integer.parseInt(String.valueOf(a)));
//                        heSoB = Integer.parseInt(String.valueOf(b));
//                        if (heSoA > 0) {
//                            txtDongBien.setText("Hàm số đồng biến trên R");
//                        } else {
//                            txtDongBien.setText("Hàm số nghịch biến trên R");
//                        }
//
//                    } else {
//                        // nếu giá trị a không âm
//                        try {
//                            // tách thành các ký tự để lấy các tham số a, b
//                            char a = graph.charAt(4); // hệ số b của pt: y = ax + b
//                            char b = graph.charAt(10); // hệ số b của pt: y = ax + b
//                            operator = graph.charAt(8); // hệ số b của pt: y = ax + b
//                            //Toast.makeText(GraphViewActivity.this, heSoA + " " + operator + " " + heSoB, Toast.LENGTH_LONG).show();
//                            // phải chuyển kiểu char thành int, nếu không sẽ ra kết quả không đúng
//                            heSoA = Integer.parseInt(String.valueOf(a));
//                            heSoB = Integer.parseInt(String.valueOf(b));
//                            if (heSoA > 0) {
//                                txtDongBien.setText("Hàm số đồng biến trên R");
//                            } else {
//                                txtDongBien.setText("Hàm số nghịch biến trên R");
//                            }
//                        } catch (Exception e) {
//                            Toast.makeText(GraphViewActivity.this, "Không đúng định dạng!", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                } else {
//                    try {
//                        // tách thành các ký tự để lấy các tham số a, b
//                        char a = graph.charAt(4); // hệ số a của pt: y = ax + b
//                        char b = graph.charAt(10); // hệ số b của pt: y = ax + b
//                        operator = graph.charAt(8); // hệ số b của pt: y = ax + b
//                        //Toast.makeText(GraphViewActivity.this, heSoA + " " + operator + " " + heSoB, Toast.LENGTH_LONG).show();
//                        // phải chuyển kiểu char thành int, nếu không sẽ ra kết quả không đúng
//                        heSoA = Integer.parseInt(String.valueOf(a));
//                        heSoB = Integer.parseInt(String.valueOf(b));
//                        if (heSoA > 0) {
//                            txtDongBien.setText("Hàm số đồng biến trên R");
//                        } else {
//                            txtDongBien.setText("Hàm số nghịch biến trên R");
//                        }
//                    } catch (Exception e) {
//                        // Toast.makeText(GraphViewActivity.this, "Vui lòng thử lại!", Toast.LENGTH_LONG).show();
//                    }
//                }
            }
        }
    }

//    private void drawGraph() {
////        double x, y;
////        x = 0;
////        series1 = new LineGraphSeries<>();
////        series2 = new LineGraphSeries<>();
////
////        int numDataPoints = 250;
////        for (int i = 0; i < numDataPoints; i++) {
////            x = x + 0.1;
////            y = Math.sin(x);
////            double y2 = Math.cos(x);
////            series1.appendData(new DataPoint(x, y), true, 60);
////            series2.appendData(new DataPoint(x, y2), true, 60);
////        }
//        //        series1.setColor(Color.RED);
////        series2.setColor(Color.BLUE);
//        //        graphView.addSeries(series1);
////        graphView.addSeries(series2);
//
//        // DataPoint là các tọa độ điểm (x, y) trên đồ thị
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(x1, operator == '+' ? ((heSoA * x1) + heSoB) : ((heSoA * x1) - heSoB)),
//                new DataPoint(x2, operator == '+' ? ((heSoA * x2) + heSoB) : ((heSoA * x2) - heSoB)),
//                new DataPoint(x3, operator == '+' ? ((heSoA * x3) + heSoB) : ((heSoA * x3) - heSoB)),
//                new DataPoint(x4, operator == '+' ? ((heSoA * x4) + heSoB) : ((heSoA * x4) - heSoB)),
//                new DataPoint(x5, operator == '+' ? ((heSoA * x5) + heSoB) : ((heSoA * x5) - heSoB)),
//                new DataPoint(x6, operator == '+' ? ((heSoA * x6) + heSoB) : ((heSoA * x6) - heSoB)),
//                new DataPoint(x7, operator == '+' ? ((heSoA * x7) + heSoB) : ((heSoA * x7) - heSoB)),
//
//        });
//        series.setColor(Color.RED);
//        series.setThickness(6); // set độ dày của đường đồ thị
//        series.setDrawDataPoints(true);
//        series.findDataPointAtX(x1);
//        graphView.addSeries(series);
//
//    }

    private void addEvents() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.toolBarGraph);
        toolbar.setTitle("Đồ thị hàm số");
        graphView = (GraphView) findViewById(R.id.graph_view);
        txtGraph = (TextView) findViewById(R.id.txtGraph);
        //txtDongBien = (TextView) findViewById(R.id.txtDongBien);
    }
}
