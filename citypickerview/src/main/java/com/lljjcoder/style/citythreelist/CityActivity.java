package com.lljjcoder.style.citythreelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citylist.bean.CityInfoBean;
import com.lljjcoder.style.citypickerview.R;
import com.lljjcoder.widget.RecycleViewDividerForList;

import java.util.List;

import static com.lljjcoder.style.citylist.utils.CityListLoader.BUNDATA;

public class CityActivity extends Activity {
    
    private TextView mCityNameTv;
    private ImageView mImgBack;
    private RecyclerView mCityRecyclerView;
    
    private CityInfoBean mProInfo = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citylist);
        mProInfo = this.getIntent().getParcelableExtra(BUNDATA);
        initView();
        
        setData(mProInfo);
        
    }
    
    private void setData(CityInfoBean mProInfo) {
        
        if (mProInfo != null && mProInfo.getCityList().size() > 0) {
            mCityNameTv.setText("" + mProInfo.getName());
            
            final List<CityInfoBean> cityList = mProInfo.getCityList();
            if (cityList == null) {
                return;
            }
            
            CityAdapter cityAdapter = new CityAdapter(CityActivity.this, cityList);
            mCityRecyclerView.setAdapter(cityAdapter);
            cityAdapter.setOnItemClickListener(new CityAdapter.OnItemSelectedListener() {
                @Override
                public void onItemSelected(View view, int position) {
                    ToastUtils.showLongToast(CityActivity.this, "" + cityList.get(position).getName());
                    Intent intent = new Intent(CityActivity.this, AreaActivity.class);
                    intent.putExtra(BUNDATA, cityList.get(position));
                    startActivity(intent);
                }
            });
            
        }
    }
    
    private void initView() {
        mImgBack = (ImageView) findViewById(R.id.img_left);
        mCityNameTv = (TextView) findViewById(R.id.cityname_tv);
        mImgBack.setVisibility(View.VISIBLE);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCityNameTv = (TextView) findViewById(R.id.cityname_tv);
        mCityRecyclerView = (RecyclerView) findViewById(R.id.city_recyclerview);
        mCityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCityRecyclerView.addItemDecoration(new RecycleViewDividerForList(this, LinearLayoutManager.HORIZONTAL, true));
        
    }
    
}
