package com.ihidea.as.citypicker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ihidea.as.citypicker.R;
import com.ihidea.as.citypicker.widget.wheel.OnWheelChangedListener;
import com.ihidea.as.citypicker.widget.wheel.WheelView;
import com.ihidea.as.citypicker.widget.wheel.adapters.ArrayWheelAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener, OnWheelChangedListener {
    private WheelView mViewProvince;
    
    private WheelView mViewCity;
    
    private WheelView mViewDistrict;
    
    private TextView mTvResult;
    
    private TextView mTvOK;
    
    private TextView mTvCancel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setUpListener();
        setUpData();
    }
    
    private void setUpViews() {
        mViewProvince = (WheelView) findViewById(R.id.id_province);
        mViewCity = (WheelView) findViewById(R.id.id_city);
        mViewDistrict = (WheelView) findViewById(R.id.id_district);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mTvOK = (TextView) findViewById(R.id.tv_confirm);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
    }
    
    private void setUpListener() {
        mViewProvince.addChangingListener(this);
        mViewCity.addChangingListener(this);
        mViewDistrict.addChangingListener(this);
        mTvCancel.setOnClickListener(this);
        mTvOK.setOnClickListener(this);
    }
    
    private void setUpData() {
        
        //初始化城市数据
        initProvinceDatas();
        mViewProvince.setViewAdapter(new ArrayWheelAdapter<String>(MainActivity.this, mProvinceDatas));
        
        // 设置可见条目数量
        mViewProvince.setVisibleItems(7);
        mViewCity.setVisibleItems(7);
        mViewDistrict.setVisibleItems(7);
        
        //设置省份数据循环、城市数据不循环、县数据循环
        mViewProvince.setCyclic(true);
        mViewCity.setCyclic(false);
        mViewDistrict.setCyclic(true);
        
        //设置默认的城市和县数据
        updateCities();
        updateAreas();
    }
    
    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        if (wheel == mViewProvince) {//转动省份滚轮，更新城市数据
            updateCities();
        }
        else if (wheel == mViewCity) {//转动城市滚轮，更新县数据
            updateAreas();
        }
        else if (wheel == mViewDistrict) {//转动县数据，保存县数据
            mCurrentDistrictName = mDistrictDatasMap.get(mCurrentCityName)[newValue];
            mCurrentZipCode = mZipcodeDatasMap.get(mCurrentDistrictName);
        }
    }
    
    /**
     * 根据当前的市，更新区WheelView的信息
     */
    private void updateAreas() {
        int pCurrent = mViewCity.getCurrentItem();
        mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[pCurrent];
        String[] areas = mDistrictDatasMap.get(mCurrentCityName);
        
        if (areas == null) {
            areas = new String[] { "" };
        }
        mViewDistrict.setViewAdapter(new ArrayWheelAdapter<String>(this, areas));
        mViewDistrict.setCurrentItem(0);
        
        //获取第一个区名称
        mCurrentDistrictName = mDistrictDatasMap.get(mCurrentCityName)[0];
        mCurrentZipCode = mZipcodeDatasMap.get(mCurrentDistrictName);
    }
    
    /**
     * 根据当前的省，更新市WheelView的信息
     */
    private void updateCities() {
        int pCurrent = mViewProvince.getCurrentItem();
        mCurrentProviceName = mProvinceDatas[pCurrent];
        String[] cities = mCitisDatasMap.get(mCurrentProviceName);
        if (cities == null) {
            cities = new String[] { "" };
        }
        mViewCity.setViewAdapter(new ArrayWheelAdapter<String>(this, cities));
        mViewCity.setCurrentItem(0);
        updateAreas();
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_confirm:
                mTvResult.setText("当前选中:" + mCurrentProviceName + "," + mCurrentCityName + "," + mCurrentDistrictName
                        + "," + mCurrentZipCode);
                break;
            default:
                break;
        }
    }
    
}
