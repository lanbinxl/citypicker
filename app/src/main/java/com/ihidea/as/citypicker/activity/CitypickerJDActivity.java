package com.ihidea.as.citypicker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihidea.as.citypicker.R;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.style.cityjd.JDCityPicker;

public class CitypickerJDActivity extends AppCompatActivity {
    JDCityPicker cityPicker;
    private Button jdBtn;
    private TextView resultV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citypicker_jd);

        jdBtn = (Button) findViewById(R.id.jd_btn);
        resultV = (TextView) findViewById(R.id.result_tv);
        cityPicker = new JDCityPicker();
        cityPicker.init(this);
        cityPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                resultV.setText("城市选择结果：\n" + province.getName() + "(" + province.getId() + ")\n"
                        + city.getName() + "(" + city.getId() + ")\n"
                        + district.getName() + "(" + district.getId() + ")");
            }

            @Override
            public void onCancel() {
            }
        });
        jdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJD();
            }
        });
    }


    private void showJD() {
        cityPicker.showCityPicker();
    }
}
