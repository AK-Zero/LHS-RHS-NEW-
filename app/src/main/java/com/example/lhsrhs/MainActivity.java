package com.example.lhsrhs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LHSFragment lhs = new LHSFragment();
    RHSFragment rhs = new RHSFragment();
    Button reset , eraser , changecolor;
    int stat=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = findViewById(R.id.reset);
        eraser = findViewById(R.id.eraser);
        changecolor = findViewById(R.id.changecolor);
        getSupportFragmentManager().beginTransaction().replace(R.id.LHS , lhs).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.RHS , rhs).commit();
        Toast t = Toast.makeText(MainActivity.this , "Draw Away..." , Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
        t.show();
        reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                lhs.setreset();
                rhs.setreset();
                eraser.setText("ERASER");
                if(stat%2==0) {
                    stat++;
                    lhs.seteraser();
                    rhs.seteraser();
                }
            }
        });
        eraser.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(stat%2==1){
                    changecolor.setEnabled(false);
                    eraser.setText("BRUSH");
                }
                else{
                    changecolor.setEnabled(true);
                    eraser.setText("ERASER");
                }
                stat++;
                lhs.seteraser();
                rhs.seteraser();
            }
        });
        changecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lhs.setchangecolor();
                rhs.setchangecolor();
            }
        });
    }
}
