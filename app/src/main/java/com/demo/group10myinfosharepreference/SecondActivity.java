package com.demo.group10myinfosharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView stvname, stvage;
    Button sbtnlogout, btnRetrieve;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        stvname = findViewById(R.id.stvname);
        stvage = findViewById(R.id.stvage);
        sbtnlogout = findViewById(R.id.sbtnlogout);
        btnRetrieve = findViewById(R.id.btn_retrieve);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        String sname = sharedPreferences.getString("NAME", "");
        stvname.setText(sname);

        int sage = sharedPreferences.getInt("AGE", 0);
        stvage.setText("" + sage);

        sbtnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}