package com.cookandroid.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.security.Permission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        레이아웃 1 : 홈페이지 이동
        Button btnWeb;
        btnWeb = (Button) findViewById(R.id.btnWeb);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.beautifulstore.org/intro-donation#none");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

//        레이아웃 1 : 홈 이동(돌아가기)
        Button btnHome;
        btnHome = (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });


//        레이아웃 2 : 카테고리 라디오버튼
        TextView tvCategory;
        RadioGroup rGroup;
        RadioButton radiobtn1, radiobtn2, radiobtn3, radiobtn4, radiobtn5, radiobtn6;
        tvCategory = (TextView) findViewById(R.id.tvCategory);
        rGroup = (RadioGroup) findViewById((R.id.rGroup));
        radiobtn1 = (RadioButton) findViewById(R.id.radiobtn1);
        radiobtn2 = (RadioButton) findViewById(R.id.radiobtn2);
        radiobtn3 = (RadioButton) findViewById(R.id.radiobtn3);
        radiobtn4 = (RadioButton) findViewById(R.id.radiobtn4);
        radiobtn5 = (RadioButton) findViewById(R.id.radiobtn5);
        radiobtn6 = (RadioButton) findViewById(R.id.radiobtn6);
        String radioState;

        public void onRadioButtonClicked(View view) {
            boolean checked = ((RadioButton) view).isChecked();

            switch (view.getId()) {
                case R.id.radiobtn1:
                    radioState = "의류";
                case R.id.radiobtn2:
                    radioState = "영유아 잡화";
                case R.id.radiobtn3:
                    radioState = "주방·생활 잡화";
                case R.id.radiobtn4:
                    radioState = "패션·미용 잡화";
                case R.id.radiobtn5:
                    radioState = "도서·음반";
                case R.id.radiobtn6:
                    radioState = "가전";
            }
        }

//        레이아웃 3 :
        TextView tvName;
        EditText edName;
        String name;
        tvName = (TextView) findViewById(R.id.tvName);
        edName = (EditText) findViewById(R.id.edName) ;
        name = edName.getText().toString();

//        레이아웃 4 :
        TextView tvPicture;
        Button btnUpload;
        tvPicture = (TextView) findViewById(R.id.tvPicture);
        btnUpload = (Button) findViewById(R.id.btnUpload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType(MediaStore.Images.Media.CONTENT_TYPE);

                }
            }
        });

//        레이아웃 5 :
        Button btnOk;
        ImageView imgLogo;
        btnOk = (Button) findViewById(R.id.btnOk);
        imgLogo = (ImageView) findViewById(R.id.imgLogo);



}
