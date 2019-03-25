package com.example.uocchung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView txSoa, txSob, txUcln, txBcnn;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Init();
        act();
        exit();

    }

    public void exit() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void act() {
        Intent i = this.getIntent();
        //lấy dữ liệu từ MainActivity
        String a = i.getStringExtra("num_a");
        String b = i.getStringExtra("num_b");
        //chuyển dữ liệu từ MainActivity sang kiểu int
        int num_a = Integer.parseInt(a);
        int num_b = Integer.parseInt(b);
        //gọi hàm tính UCLN, BCNN
        int ucln = UCLN(num_a, num_b);
        int bcnn = BCNN(num_a, num_b);
        //chuyển kq từ int sang String
        String uc = Integer.toString(ucln);
        String bc = Integer.toString(bcnn);
        //hiển thị kết quả lên Activity2
        txSoa.setText(a);
        txSob.setText(b);
        txUcln.setText(uc);
        txBcnn.setText(bc);


    }


    public int BCNN(int a, int b) {
        return (a*b)/UCLN(a,b);
    }

    //giải thuật Euclid
    public int UCLN(int a, int b) {
        if(b == 0) return a;
        return UCLN(b, a % b);
    }

    public void Init() {
        //Ánh Xạ
        txSoa = findViewById(R.id.txSoa);
        txSob = findViewById(R.id.txSob);
        txUcln = findViewById(R.id.txUcln);
        txBcnn = findViewById(R.id.txBcnn);
        btnExit = findViewById(R.id.btnExit);
    }
}
/// Test