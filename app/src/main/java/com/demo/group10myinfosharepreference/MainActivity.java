package com.demo.group10myinfosharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtname, edtage;
    CheckBox chkrme;
    Button btnlogin, btnRetrieve;
    SharedPreferences sharedPreferences;
    boolean ischkrme = false;
    public static final String mypreference = "SHARED_PREF";
    public static final String Name = "nameKey";
    public static final String Age = "nameAge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = findViewById(R.id.edtname);
        edtage = findViewById(R.id.edtage);
        chkrme = findViewById(R.id.chkrme);
        btnlogin = findViewById(R.id.btn_login);
        btnRetrieve = findViewById(R.id.btn_retrieve);

        sharedPreferences = getSharedPreferences ("SHARED_PREF", MODE_PRIVATE);
        ischkrme = sharedPreferences.getBoolean("RME",false);

        if (ischkrme) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtname.getText().toString();
                int age = Integer.parseInt(edtage.getText().toString().trim());
                boolean rme = chkrme.isChecked();

                SharedPreferences. Editor editor = sharedPreferences.edit();
                editor.putString("NAME", name);
                editor.putInt("AGE", age);
                editor.putBoolean("RME", rme);
                editor.apply();

                Toast.makeText(MainActivity.this,"Information Saved!!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtage = findViewById(R.id.edtage);
                sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

                if (sharedPreferences.contains(Age)) {
                    edtage.setText(sharedPreferences.getInt(Age, 0));
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}