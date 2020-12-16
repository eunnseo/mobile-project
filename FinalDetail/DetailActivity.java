package com.cookandroid.teamproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


        String name = "";
        String price = "";
        String store_loc = "";

        Bundle extras = getIntent().getExtras();

        name = extras.getString("name");
        price = extras.getString("price");
        store_loc = extras.getString("store_loc");


//        TextView textView = (TextView) findViewById(R.id.textView_result);
        TextView dataName2 = (TextView) findViewById(R.id.dataName2);
        TextView dataName3 = (TextView) findViewById(R.id.dataName3);
        TextView dataName4 = (TextView) findViewById(R.id.dataName4);

//        String str = name + '\n' + price + '\n' + store_loc;
//        textView.setText(str);
        dataName2.setText(name + '\n');
        dataName3.setText(price + '\n');
        dataName4.setText(store_loc + '\n');


        // 홈으로 돌아가기
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

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
