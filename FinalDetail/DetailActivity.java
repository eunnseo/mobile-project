package com.cookandroid.teamproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class DetailActivity extends AppCompatActivity {

    Button btnHome;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        String category = "";
        String name = "";
        String price = "";
        String store_loc = "";
        Bitmap image1, image2, image3;

        Bundle extras = getIntent().getExtras();

        // 메인 페이지에서 인텐트로 받은 데이터 가져오기
        category = extras.getString("category");
        name = extras.getString("name");
        price = extras.getString("price");
        store_loc = extras.getString("store_loc");

        image1 = (Bitmap) extras.get("image1");
        image2 = (Bitmap) extras.get("image2");
        image3 = (Bitmap) extras.get("image3");

        TextView dataName1 = (TextView) findViewById(R.id.dataName1);
        TextView dataName2 = (TextView) findViewById(R.id.dataName2);
        TextView dataName3 = (TextView) findViewById(R.id.dataName3);
        TextView dataName4 = (TextView) findViewById(R.id.dataName4);

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        ImageView img3 = (ImageView) findViewById(R.id.img3);

        // 데이터 세팅
        dataName1.setText(category);
        dataName2.setText(name);
        dataName3.setText(price);
        dataName4.setText(store_loc);

        img1.setImageBitmap(image1);
        img2.setImageBitmap(image2);
        img3.setImageBitmap(image3);


        // 홈으로 돌아가기
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    // 예약
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragement();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this,"Date: "+dateMessage,Toast.LENGTH_SHORT).show();
    }

}
