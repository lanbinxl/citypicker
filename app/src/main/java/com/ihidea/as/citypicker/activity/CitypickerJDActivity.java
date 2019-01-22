package com.ihidea.as.citypicker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihidea.as.citypicker.R;
import com.lljjcoder.style.cityjd.JDCityPicker;

public class CitypickerJDActivity extends AppCompatActivity {

    private Button jdBtn;
    private TextView resultV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citypicker_jd);

        jdBtn = (Button) findViewById(R.id.jd_btn);
        resultV = (TextView) findViewById(R.id.result_tv);

        jdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJD();
            }
        });
    }


    private void showJD() {
        JDCityPicker cityPicker = new JDCityPicker();
        cityPicker.init(this);
        cityPicker.showCityPicker();
    }
}
