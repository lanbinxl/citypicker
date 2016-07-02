## citypicker Android Studio实现

![](http://img.blog.csdn.net/20160702160946025)

### 前言
在实际的项目中需要使用到省市区三级联动的功能，在网上找来找去，都没有找到一个合适的库， 所以自己就封装了一个，不需要自己添加数据源，直接引用即可，一行代码搞定城市选择。怎么简单，怎么方便，怎么来，就是这么任性！

### 亮点
无需自己配置省市区域的数据，不需要再进行解析之类的繁杂操作，只需引用即可，结果返回省市区和邮编等四项数据信息，如果不满意样式的话可以自己修改源码！


### 使用
**V0.1.0版本更新内容**
1：直接传入context获取省市区信息




**Gradle引用**

```
    compile 'liji.library.dev:citypickerview:0.1.0'

```



**代码示例：**
```
 CityPickerView cityPickerView = new CityPickerView(MainActivity.this);
        cityPickerView.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                 
            }
        });
        cityPickerView.show();
```
**结果返回**
只需传入Context便可获取选择的省市区域的信息，结果返回四项，可根据自己的实际需求进行选择。

 1. citySelected[0]：表示：省份信息
 2. citySelected[1]：表示：城市信息
 3. citySelected[2]：表示：区县信息
 4. citySelected[3]：表示：邮编信息


### 效果预览
#### 应用在实际项目中效果
![](http://img.blog.csdn.net/20160513153736550)

![](http://img.blog.csdn.net/20160513153748475)

![](http://img.blog.csdn.net/20160513153756003)



### 数据来源
数据来源主要有2种方式，可根据喜好选择哪种方式使用。

#### xml数据
![](http://img.blog.csdn.net/20160512153839068)

#### json数据
![](http://img.blog.csdn.net/20160512153906553)

### APK下载

1. [APK下载地址CSDN](http://download.csdn.net/detail/lj188266/9518048)
2. [fir下载](http://fir.im/xce2?release_id=57392423f2fc421f7900000e)

### 关于我
[我的个人博客](http://crazyandcoder.github.io/about/)

### 感谢

- [http://blog.csdn.net/wulianghuan/article/details/41549189](http://blog.csdn.net/wulianghuan/article/details/41549189)



