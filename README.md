### **CityPicker 城市选择器**

#### **说明**

在实际的项目中一般情况下都需要使用到省市区三级联动地址选择的功能，有的公司是提供接口获取，有的公司则不是，需要自己实现。一开始，我也深受其扰，每次都是要复制一遍，就想能不能打个包出来，供大伙使用。所以自己就封装了一个，不需要自己添加数据源，直接引用即可。这就是CityPicker城市选择器的由来！



#### **效果展示**


![](http://img.blog.csdn.net/20171217104511214?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)  

**仿iOS滚轮实现**

![](http://img.blog.csdn.net/20171217113122669?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) ![](http://img.blog.csdn.net/20171217113133546?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**城市一级列表展示效果图**

 ![](http://img.blog.csdn.net/20171217110803599?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)     ![](http://img.blog.csdn.net/20171217112213023?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**省市区三级列表展示效果图**

![](http://img.blog.csdn.net/20171217112838613?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) ![](http://img.blog.csdn.net/20171217112850749?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) ![](http://img.blog.csdn.net/20171217112902207?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


### **使用方法**

#### **gradle引用**

```
compile 'liji.library.dev:citypickerview:3.0.1'
```

#### **代码混淆**

```
#地区3级联动选择器

-keep class com.lljjcoder.**{
	*;
}
```
#### **列表样式使用代码**

 1. [城市一级列表样式使用方法及demo](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E4%BA%8C%EF%BC%88%E5%9F%8E%E5%B8%82%E4%B8%80%E7%BA%A7%E5%88%97%E8%A1%A8%E5%B1%95%E7%A4%BA%EF%BC%89)
 2. [省市区三级列表使用方法及demo](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E4%B8%89%EF%BC%88%E7%9C%81%E5%B8%82%E5%8C%BA%E4%B8%89%E7%BA%A7%E5%88%97%E8%A1%A8%EF%BC%89)

#### **仿iOS滚轮样式使用代码**

首先需要预加载数据，我们可以在自定义的Application中写入以下代码（选择其中一个即可，三个不必都写）：

```

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 预先加载仿iOS滚轮实现的全部数据
         */
        CityPickerView.getInstance().init(this);
        
        /**
         * 预先加载一级列表所有城市的数据
         */
        CityListLoader.getInstance().loadCityData(this);
        
        /**
         * 预先加载三级列表显示省市区的数据
         */
        CityListLoader.getInstance().loadProData(this);
    }
}

```

以上三行预加载本地城市数据的代码也可以放入到使用的activity的页面中。然后在使用的当前activity中添加使用代码，如果使用默认的属性的话可以直接使用下面的代码：

```

//添加默认的配置，不需要自己定义
CityPickerView.getInstance().setConfig(new CityConfig.Builder(this).build();

//监听选择点击事件及返回结果
CityPickerView.getInstance().setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                 
                //省份
                if (province != null) {
                    
                }
                
                //城市
                if (city != null) {
                    
                }
                
                //地区
                if (district != null) {
                    
                }
                
                mResultTv.setText("" + sb.toString());
                
            }
            
            @Override
            public void onCancel() {
                ToastUtils.showLongToast(CitypickerWheelActivity.this, "已取消");
            }
        });

		//显示
        CityPickerView.getInstance().showCityPicker(this);
```

通过以上代码我们就可以显示默认的省市区三级联动的选择器，当然也支持使用自定义的属性。

```
CityConfig cityConfig = new CityConfig.Builder(CitypickerWheelActivity.this).title("选择城市")//标题
                .titleTextSize(18)//标题文字大小
                .titleTextColor("#585858")//标题文字颜色
                .titleBackgroundColor("#E9E9E9")//标题栏背景色
                .confirTextColor("#585858")//确认按钮文字颜色
                .confirmText("ok")//确认按钮文字
                .confirmTextSize(16)//确认按钮文字大小
                .cancelTextColor("#585858")//取消按钮文字颜色
                .cancelText("cancel")//取消按钮文字
                .cancelTextSize(16)//取消按钮文字大小
                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)//显示类，只显示省份一级，显示省市两级还是显示省市区三级
                .showBackground(true)//是否显示半透明背景
                .visibleItemsCount(7)//显示item的数量
                .province("浙江省")//默认显示的省份
                .city("杭州市")//默认显示省份下面的城市
                .district("滨江区")//默认显示省市下面的区县数据
                .provinceCyclic(true)//省份滚轮是否可以循环滚动
                .cityCyclic(true)//城市滚轮是否可以循环滚动
                .districtCyclic(true)//区县滚轮是否循环滚动
                .setCustomItemLayout(R.layout.item_city)//自定义item的布局
                .setCustomItemTextViewId(R.id.item_city_name_tv)//自定义item布局里面的textViewid
                .build();

//设置自定义的属性配置
CityPickerView.getInstance().setConfig(cityConfig);
                
```

以上若是使用了自定义的item布局的话，可以自定义item里面的背景、文字大小颜色等属性，下面是展示默认的布局。**使用自定义的布局时需要注意的是，里面需要包含一个TextView控件，同时控件id需要一致，否则不显示结果。**

```
//自定义的item_city.xml布局

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <TextView
        android:id="@+id/item_city_name_tv"
        android:layout_width="match_parent"
        android:layout_height="45dp"
        android:gravity="center"
        android:text="hello"
        android:textSize="18sp"
        android:textStyle="bold"/>
</LinearLayout>
```

**返回结果的数据接口**

ProvinceBean province, CityBean city, DistrictBean district都是一样的数据结构。
```
id  //城市code
name //城市名称
pinYin //城市拼音
gisGcj02Lat //高德坐标系-纬度
gisGcj02Lng //高德坐标系-经度
gisBd09Lat //百度坐标系-纬度
gisBd09Lng //百度坐标系-经度


```

### **更新说明**

#### **V3.0.1版本更新内容（2017.12.23）**

 1. [修复重庆后面出现空白的bug](https://github.com/crazyandcoder/citypicker/issues/53)
 2. [更新中山市和东莞市的数据源](https://github.com/crazyandcoder/citypicker/issues/82)

[历史更新说明](https://github.com/crazyandcoder/citypicker/wiki/%E5%8E%86%E5%8F%B2%E6%9B%B4%E6%96%B0%E8%AE%B0%E5%BD%95)

### **赞赏**

如果你喜欢 citypicker 的设计，感觉 citypicker 帮助到了你，可以点右上角 "Star" 支持一下 谢谢！,你也还可以扫描下面的二维码~ 请作者喝一杯牛奶，让作者更有动力写出更好的开源库服务大家。^_^


 ![](http://img.blog.csdn.net/20180102115819490?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)              ![](http://img.blog.csdn.net/20180102115834628?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 
**赞赏的伙计，请留下你们的联系方式(最好是GitHub地址)，我好扶你们上墙。**
 
 
### **赞赏人员列表**
[赞赏的人](https://github.com/crazyandcoder/citypicker/wiki/%E8%B5%9E%E8%B5%8F%E7%9A%84%E4%BA%BA)



 
