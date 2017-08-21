package com.ihidea.as.citypicker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lljjcoder.city_20170724.CityPickerView;
import com.lljjcoder.city_20170724.bean.CityBean;
import com.lljjcoder.city_20170724.bean.DistrictBean;
import com.lljjcoder.city_20170724.bean.ProvinceBean;
import com.lljjcoder.citylist.CityListSelectActivity;
import com.lljjcoder.citylist.bean.CityInfoBean;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        
        tvResult.setText("" + increasedVersionCode());
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
                CityPickerView cityPicker = new CityPickerView.Builder(MainActivity.this).textSize(20)
                        .titleTextColor("#000000")
                        .backgroundPop(0xa0000000)
                        .province("江苏省")
                        .city("南京市")
                        .district("秦淮区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(true)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .build();
                cityPicker.show();
                cityPicker.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
                    @Override
                    public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                        //返回结果
                    }
                    
                    @Override
                    public void onCancel() {
                        
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
                
                tvResult.setText("城市： " + cityName + "\n" + "经度： " + latitude + "\n" + "纬度： " + longitude);
            }
        }
    }
    
    // // versionCode按时间自增
    int increasedVersionCode() {
        long time = System.currentTimeMillis();//long now = android.os.SystemClock.uptimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH");
        Date d1 = new Date(time);
        String t1 = format.format(d1);
        String[] hours = t1.split("-");
        int result = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : hours) {
            stringBuffer.append(s);
        }
        if (!TextUtils.isEmpty(stringBuffer.toString()))
            result = Integer.parseInt(stringBuffer.toString());
        if (result > 2147483647) {
            result = 0;
        }
        return result;
    }
}
