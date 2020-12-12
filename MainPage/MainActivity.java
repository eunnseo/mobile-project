package com.cookandroid.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnDonate, btnMyPage, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Page");

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        btnDonate = (Button) findViewById(R.id.btnDonate);
        btnMyPage = (Button) findViewById(R.id.btnMyPage);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnMyPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MypageActivity.class);
                startActivity(intent);
            }
        });

        btnDonate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        DonateActivity.class);
                startActivity(intent);
            }
        });
    }
}
