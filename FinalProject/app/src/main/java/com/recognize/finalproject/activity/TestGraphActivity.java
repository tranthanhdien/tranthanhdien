package com.recognize.finalproject.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.recognize.finalproject.R;

public class TestGraphActivity extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series1, series2;
    Toolbar toolbar;
    GraphView graphView;
    double heSoA = 2;
    double heSoB = 2;
    double heSoC = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_graph);

        getSupportActionBar().hide(); // ẩn thanh ActionBar đi
        addControls();
        drawGraph();


    }

    private void drawGraph() {
        double delta = (heSoB*heSoB) - (4 * heSoA * (-heSoC)); // tính delta
        double axisOfSymmetryX = -heSoB / (2 * heSoA); // trục đối xứng
        double axisOfSymmetryY = -delta / (4 * heSoA); // trục đối xứng
        double y1, y2, y3, y4, y5, y6; // hệ số x, y
        double x1 = -3;
        double x2 = -2;
        double x3 = -1;
        double x4 = 0;
        double x5 = 1;
        double x6 = 2;
        // chỉ cần tìm độ 5 điểm là có thể vẽ được đồ thị
        y1 = ((heSoA * (x1*x1)) + (heSoB * x1) - heSoC);
        y2 = ((heSoA * (x2*x2)) + (heSoB * x2) - heSoC);
        y3 = ((heSoA * (x3*x3)) + (heSoB * x3) - heSoC);
        y4 = ((heSoA * (x4*x4)) + (heSoB * x4) - heSoC);
        y5 = ((heSoA * (x5*x5)) + (heSoB * x5) - heSoC);
        y6 = ((heSoA * (x6*x6)) + (heSoB * x6) - heSoC);
//        Toast.makeText(TestGraphActivity.this, x1 + "" + y1, Toast.LENGTH_LONG).show();
//        Toast.makeText(TestGraphActivity.this, axisOfSymmetryX + "" + axisOfSymmetryY, Toast.LENGTH_LONG).show();
//        Toast.makeText(TestGraphActivity.this, x2 + "" + y2, Toast.LENGTH_LONG).show();
//        Toast.makeText(TestGraphActivity.this, x3 + "" + y3, Toast.LENGTH_LONG).show();
//        Toast.makeText(TestGraphActivity.this, x4 + "" + y4, Toast.LENGTH_LONG).show();


        // Lưu ý: Khi thêm DataPoint phải chú ý thêm giá trị x từ nhỏ đến lớn nếu không đúng thứ tự sẽ bị lỗi ngay
        LineGraphSeries<DataPoint> serie2 = new LineGraphSeries<>();
        serie2.appendData(new DataPoint(axisOfSymmetryX, -5), true, 60);
        serie2.appendData(new DataPoint(axisOfSymmetryX, 10), true, 60);
        LineGraphSeries<DataPoint> serie1 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(x1, y1),
                new DataPoint(x2, y2),
                new DataPoint(x3, y3),
                new DataPoint(axisOfSymmetryX, axisOfSymmetryY),
                new DataPoint(x4, y4),
                new DataPoint(x5, y5),
                new DataPoint(x6, y6),
        });
        serie2.setColor(Color.BLUE);
        serie2.setThickness(10);

        serie1.setColor(Color.RED);
        serie1.setThickness(6); // set độ dày của đường đồ thị
        serie1.setDrawDataPoints(true);
        graphView.addSeries(serie1);
        graphView.addSeries(serie2);


    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.toolBarGraphTest);
        toolbar.setTitle("Đồ thị hàm số");
        graphView = (GraphView) findViewById(R.id.graphViewTest);
    }
}
