package com.cookandroid.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Permission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnWeb;
        TextView tvCategory, tvName, tvPicture;
        CheckBox check1, check2, check3, check4, check5, check6;
        EditText edName;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_get_image);
        tedPermission();

        btnWeb = (Button) findViewById(R.id.btnWeb);

        tvCategory = (TextView) findViewById(R.id.tvCategory);
        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);
        check4 = (CheckBox) findViewById(R.id.check4);
        check5 = (CheckBox) findViewById(R.id.check5);
        check6 = (CheckBox) findViewById(R.id.check6);

        tvName = (TextView) findViewById(R.id.tvName);
        edName = (EditText) findViewById(R.id.edName) ;


        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.beautifulstore.org/intro-donation#none");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(check1.isChecked() == true) {

                } else {

                }
            }
        });



    }

    private void tedPermission() {
        PermissionListner permissionListner = new PermissionLister () {
            public void onPermissionGranted() {

            }

            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListner(permissionListner)
                .setRationaleMessage(getResources().getString())
    }
}
