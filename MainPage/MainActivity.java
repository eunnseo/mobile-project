package com.cookandroid.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnDonate, btnMyPage, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        btnDonate = (Button) findViewById(R.id.btnDonate);
        btnMyPage = (Button) findViewById(R.id.btnMyPage);
        btnSearch = (Button) findViewById(R.id.btnSearch);
    }
}
