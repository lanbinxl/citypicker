package com.ihidea.as.citypicker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citylist.CityListSelectActivity;
import com.lljjcoder.citylist.bean.CityInfoBean;
import com.lljjcoder.citypickerview.widget.CityPicker;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    TextView tv_resultWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goList = (Button) findViewById(R.id.goList);
        Button goWheel = (Button) findViewById(R.id.goWheel);
        tv_resultWheel = (TextView) findViewById(R.id.tv_resultWheel);
        tvResult = (TextView) findViewById(R.id.tv_resultList);

        //城市列表选择器
        goList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityListSelectActivity.class);
                startActivityForResult(intent, CityListSelectActivity.CITY_SELECT_RESULT_FRAG);
            }
        });

        //城市滚轮选择器
        goWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityPicker cityPicker = new CityPicker.Builder(MainActivity.this).textSize(20)
                        .titleTextColor("#000000")
                        .backgroundPop(0xa0000000)
                        .province("江苏省")
                        .city("常州市")
                        .district("天宁区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(true)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .build();

                cityPicker.show();
                cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
                    @Override
                    public void onSelected(String... citySelected) {
                        tv_resultWheel.setText("选择结果：\n省：" + citySelected[0] + "\n市：" + citySelected[1] + "\n区："
                                + citySelected[2] + "\n邮编：" + citySelected[3]);
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this, "已取消", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CityListSelectActivity.CITY_SELECT_RESULT_FRAG) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return;
                }
                Bundle bundle = data.getExtras();

                CityInfoBean cityInfoBean = (CityInfoBean) bundle.getParcelable("cityinfo");

                if (null == cityInfoBean)
                    return;

                //城市名称
                String cityName = cityInfoBean.getName();
                //纬度
                String latitude = cityInfoBean.getLongitude();
                //经度
                String longitude = cityInfoBean.getLatitude();


                tvResult.setText("城市： " + cityName + "\n" +
                        "经度： " + latitude + "\n" +
                        "纬度： " + longitude);
            }
        }
    }
}
