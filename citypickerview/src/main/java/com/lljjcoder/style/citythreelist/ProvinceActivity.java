package com.lljjcoder.style.citythreelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citylist.bean.CityInfoBean;
import com.lljjcoder.style.citylist.utils.CityListLoader;
import com.lljjcoder.style.citypickerview.R;
import com.lljjcoder.widget.RecycleViewDividerForList;

import java.util.List;

import static com.lljjcoder.style.citylist.utils.CityListLoader.BUNDATA;

public class ProvinceActivity extends Activity {
    
    private TextView mCityNameTv;
    
    private RecyclerView mCityRecyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citylist);
        initView();
        setData();
        
    }
    
    private void setData() {
        
        final List<CityInfoBean> cityList = CityListLoader.getInstance().getProListData();
        if (cityList == null) {
            return;
        }
        
        CityAdapter cityAdapter = new CityAdapter(ProvinceActivity.this, cityList);
        mCityRecyclerView.setAdapter(cityAdapter);
        cityAdapter.setOnItemClickListener(new CityAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(View view, int position) {
                ToastUtils.showLongToast(ProvinceActivity.this, "" + cityList.get(position).getName());
                Intent intent = new Intent(ProvinceActivity.this, CityActivity.class);
                intent.putExtra(BUNDATA, cityList.get(position));
                startActivity(intent);
                
            }
        });
        
    }
    
    private void initView() {
        mCityNameTv = (TextView) findViewById(R.id.cityname_tv);
        mCityNameTv.setText("选择省份");
        mCityRecyclerView = (RecyclerView) findViewById(R.id.city_recyclerview);
        mCityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCityRecyclerView.addItemDecoration(new RecycleViewDividerForList(this, LinearLayoutManager.HORIZONTAL, true));
        
    }
    
}
