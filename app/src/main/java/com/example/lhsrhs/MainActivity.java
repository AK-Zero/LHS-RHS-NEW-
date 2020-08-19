package com.example.lhsrhs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.LHS , new LHSFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.RHS , new RHSFragment()).commit();
        Toast t = Toast.makeText(MainActivity.this , "Draw Away..." , Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
        t.show();
    }
}
