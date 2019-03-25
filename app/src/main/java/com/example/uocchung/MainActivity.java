package com.example.uocchung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtSoa, edtSob;
    Button btnXuly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        act();
    }

    private void act() {
        btnXuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callActivity2();
            }
        });
    }

    private void callActivity2() {
        String a = edtSoa.getText().toString();
        String b = edtSob.getText().toString();
        if(a.isEmpty() || b.isEmpty()){
            Toast.makeText(MainActivity.this, "Không được bỏ trống các ô trên", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(this, Activity2.class);
            i.putExtra("num_a",a);
            i.putExtra("num_b",b);
            startActivity(i);
        }
    }

    private void init() {
        edtSoa = findViewById(R.id.edtSoa);
        edtSob = findViewById(R.id.edtSob);
        btnXuly = findViewById(R.id.btnXuly);
    }
}
