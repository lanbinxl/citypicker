## citypicker Android Studio实现




### 前言
在实际的项目中需要使用到省市区三级联动的功能，在网上找来找去，都没有找到一个合适的库， 所以自己就封装了一个，不需要自己添加数据源，直接引用即可，一行代码搞定城市选择。怎么简单，怎么方便，怎么来，就是这么任性！

### 亮点

 1. 无需自己配置省市区域的数据，不需要再进行解析之类的繁杂操作，只需引用即可，结果返回省市区和邮编等四项数据信息，如果不满意样式的话可以自己修改源码！
 2. 多种样式选择，高仿iOS滚轮实现以及列表选择。

### 效果预览

![](http://img.blog.csdn.net/20170526093653244?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 应用在实际项目中效果

**1、高仿iOS滚轮实现城市选择器**

![](http://img.blog.csdn.net/20161209211413273?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)  ![](http://img.blog.csdn.net/20161209211426836?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) ![](http://img.blog.csdn.net/20161209211442594?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**2、城市列表选择器**

![](http://img.blog.csdn.net/20170526135448897?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)




----------

### 数据结构概览

> 选择结果

![](http://img.blog.csdn.net/20170822071251738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

> 省份数据结构

![](http://img.blog.csdn.net/20170822071119678?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)




> 城市数据结构

![](http://img.blog.csdn.net/20170822071228790?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

> 区县数据结构

![](http://img.blog.csdn.net/20170822071311231?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


----------





 
 
### 使用方法
#### gradle引用
```
compile 'liji.library.dev:citypickerview:2.0.1'

```
#### 代码示例

**1、城市列表选择器代码**

**友情提醒：**

列表选择器的原理主要就是通过startActivityForResult方法来实现的，如果不熟悉startActivityForResult的应用，请自行解决。

```
//首先跳转到列表页面，通过startActivityForResult实现页面跳转传值
Intent intent = new Intent(MainActivity.this, CityListSelectActivity.class);
startActivityForResult(intent, CityListSelectActivity.CITY_SELECT_RESULT_FRAG);

//接收选择器选中的结果：
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

				//获取到城市名称，经纬度值后可自行使用...
            }
        }
    }
```



**2、高仿iOS滚轮实现选择器代码**
```
CityPickerView cityPicker = new CityPickerView.Builder(MainActivity.this)
						.textSize(20)
                        .title("地址选择")
                        .backgroundPop(0xa0000000)
                        .titleBackgroundColor("#234Dfa")
			.titleTextColor("#000000")
                        .backgroundPop(0xa0000000)
                        .confirTextColor("#000000")
                        .cancelTextColor("#000000")
                        .province("江苏省")
                        .city("常州市")
                        .district("天宁区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(true)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .onlyShowProvinceAndCity(false)
                        .build();
                cityPicker.show();

		//监听方法，获取选择结果
		cityPicker.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
                    @Override
                    public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                        //返回结果
			//ProvinceBean 省份信息
			//CityBean     城市信息
			//DistrictBean 区县信息
                    }
                    
                    @Override
                    public void onCancel() {
                        
                    }
                });
```





#### 结果返回



只需传入Context便可获取选择的省市区域的信息，结果返回四项，可根据自己的实际需求进行选择。

 1. ProvinceBean：表示：省份信息
 2. CityBean：表示：城市信息
 3. DistrictBean：表示：区县信息


**返回结果参数说明**

ProvinceBean  , CityBean  , DistrictBean  同样的数据结构

![](http://img.blog.csdn.net/20170822071533962?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

> id

城市code

> name

城市名称

> pinYin

城市拼音

> gisGcj02Lat

高德坐标系-纬度

> gisGcj02Lng

高德坐标系-经度


> gisBd09Lat

百度坐标系-纬度

> gisBd09Lng

百度坐标系-经度

----------

#### 高仿iOS滚轮实现方法说明

 1. textSize（滚轮文字的大小，int 类型，默认为18）
 2. title（选择器标题，默认为“选择地区”）
 3. backgroundPop（背景，默认为半透明，16位进制颜色代码，带alpha值，如0xa0ffffff）
 4. titleBackgroundColor（标题栏背景，默认为灰色，#C7C7C7）
 5. confirTextColor（确认按钮字体颜色，默认为系统的colorPrimary颜色值）
 6. cancelTextColor（取消按钮字体颜色，默认为系统的colorPrimary颜色值）
 7. province（默认的显示省份，显示选择器后直接定位的item位置）
 8. city（默认的显示市，显示选择器后直接定位的item位置）
 9. district（默认的显示区，显示选择器后直接定位的item位置）
 10. textColor（滚轮文字的颜色 ，int 类型，默认为0xFF585858）
 11. provinceCyclic（省份的滚轮是否循环滚动）
 12. cityCyclic（市的滚轮是否循环滚动）
 13. districtCyclic（区的滚轮是否循环滚动）
 14. visibleItemsCount（滚轮显示的item个数，int 类型，默认为5个）
 15. itemPadding（滚轮item间距，默认为5dp）
 16. onlyShowProvinceAndCity(boolean flag)（是否只显示省份和市的两级联动，去掉区或者县）
 17. titleTextColor(标题文字颜色，默认为 #E9E9E9)


----------
### 更新日志

#### V2.0.2版本更新内容（2017.08.24）

 1. 更新台湾省市区数据
 2. [修复#50问题](https://github.com/crazyandcoder/citypicker/issues/50)


#### V2.0.1版本更新内容（2017.08.22）

 1. 修复选中台湾、澳门、香港时崩溃的问题；

#### V2.0.0版本更新内容（2017.08.22）

 1. 更丰富的数据结构、包含选择地区的百度、高德经纬度、城市code等；
 2. 更全面的全国省市区数据信息；
 3. 优化及修复bug。
 
#### V1.1.0版本更新内容（2017.05.26）

 1. 增加列表选择器，可获取相关城市的经纬度（百度经纬度）
 2. 修复已知的bug。

#### V1.0.0版本更新内容（2017.03.21）

 1. 修复部分城市数据不全的问题，新增香港、澳门、台湾的数据
 2. [修复#18问题](https://github.com/crazyandcoder/citypicker/issues/18)
 3. [修复#20问题](https://github.com/crazyandcoder/citypicker/issues/20)

#### V0.9.0版本更新内容（2017.01.03）

 1. 新增标题字体颜色的属性titleTextColor
 2. [修复#15问题](https://github.com/crazyandcoder/citypicker/issues/15)
 

#### V0.8.0版本更新内容（2016.12.10）

 1. 新增设置背景透明度的属性
 2. [修复#11问题](https://github.com/crazyandcoder/citypicker/issues/11)
 3. [修复#13问题](https://github.com/crazyandcoder/citypicker/issues/13)
 4. [修复#14问题](https://github.com/crazyandcoder/citypicker/issues/14)

####  V0.7.0版本更新内容（2016.11.14）

 1. [修复#10问题](https://github.com/crazyandcoder/citypicker/issues/10)

####  V0.6.0版本更新内容（2016.11.09）

 1. 修复部分城市数据不全的问题
 2. 添加修改标题的属性

####  V0.5.0版本更新内容（2016.10.28）

 1. 修复当数据源少于7个item时，设置字体颜色有阴影的bug

####  V0.4.0版本更新内容（2016.10.24）

 1. 新增只显示省市两级联动设置
 2. 新增确认和取消按钮文字颜色的设置
 3. 新增设置默认省市区的设置


####  V0.3.0版本更新内容（2016.10.13）

 1. 新增item间距属性
 2. 拆分省市区三个滚轮循环显示为分别是否循环滚动
 3. 优化代码结构


####  V0.2.0版本更新内容（2016.05.16）
1. 滚轮是否循环滚动
2. 新增文字颜色修改
3. 新增文字大小修改
4. 新增滚轮内容可见数量


#### V0.1.0版本更新内容（2016.05.08）
1. 直接传入context获取省市区信息


----------


### 关于我
1. 简书 [http://www.jianshu.com/users/18281bdb07ce/latest_articles](http://www.jianshu.com/users/18281bdb07ce/latest_articles)

2. 博客 [http://crazyandcoder.github.io/](http://crazyandcoder.github.io/)

3. github [https://github.com/crazyandcoder](https://github.com/crazyandcoder)


### 感谢


 1. [http://blog.csdn.net/wulianghuan/article/details/41549189](http://blog.csdn.net/wulianghuan/article/details/41549189)
 2. WheelView

