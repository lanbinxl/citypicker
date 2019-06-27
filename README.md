
![]()


<p align="center">
  <a href="javascript:;" rel="noopener" target="_blank"><img width="70%" src="https://img-blog.csdnimg.cn/20190130154906494.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xqMTg4MjY2,size_16,color_FFFFFF,t_70" alt="citypicker logo"></a></p>
</p>

<div align="center">

![](https://img.shields.io/badge/QQ-275137657-green.svg)
[![License](https://img.shields.io/apm/l/vim-mode.svg)](https://img.shields.io/apm/l/vim-mode.svg?style=plastic)

</div>

### **CityPicker 城市选择器**

 
**在实际的项目中一般情况下都需要使用到省市区三级联动地址选择的功能，有的公司是提供接口获取，有的公司则不是，需要自己实现。一开始，我也深受其扰，每次都是要复制一遍，就想能不能打个包出来，供大伙使用。所以自己就封装了一个，不需要自己添加数据源，直接引用即可。这就是CityPicker城市选择器的由来！**

### **功能点**

 1. 支持仿iOS滚轮实现、仿京东样式、一级城市列表、三级城市列表
 2. 支持多种自定义属性来满足你的需求
 3. 简单的几行代码即可实现城市选择器功能

### **数据来源**

[2018年12月中华人民共和国县以上行政区划代码](http://www.mca.gov.cn/article/sj/xzqh/2018/201804-12/20181201301111.html)



[台湾数据（维基百科）需翻墙](https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E8%A1%8C%E6%94%BF%E5%8C%BA%E5%88%92%E4%BB%A3%E7%A0%81_(7%E5%8C%BA))


[港澳数据（维基百科）需翻墙](https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E8%A1%8C%E6%94%BF%E5%8C%BA%E5%88%92%E4%BB%A3%E7%A0%81_(8%E5%8C%BA))





### **效果展示**



| 样式说明 | 图片效果    |
|:--------:| :--------:|
| 样式选择 | ![](https://img-blog.csdnimg.cn/20190123143912941.png)  |
| 仿iOS滚轮实现]|![8.11x16.19-1080x2050](https://img-blog.csdnimg.cn/20190123144159879.png) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144219666.png)|
|仿京东样式| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144403951.png) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144413329.png)|
| 一级城市列表| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144423843.png) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144432482.png)|
| 三级城市列表| ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144441529.png) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144449550.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190123144507182.png)|

 
 
### **CityPicker使用方法**


#### **一. 仿iOS样式使用方法**
[样式一链接-（仿iOS滚轮实现)](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E4%B8%80%EF%BC%88%E4%BB%BFiOS%E6%BB%9A%E8%BD%AE%E5%AE%9E%E7%8E%B0%EF%BC%89)

#### **二. 仿京东样式使用方法**
[样式二链接-（仿京东样式)](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E5%9B%9B%EF%BC%88%E4%BB%BF%E4%BA%AC%E4%B8%9C%E6%A0%B7%E5%BC%8F%EF%BC%89)

#### **三. 一级城市列表使用方法**
[样式三链接-一级城市列表使用方法](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E4%BA%8C%EF%BC%88%E5%9F%8E%E5%B8%82%E4%B8%80%E7%BA%A7%E5%88%97%E8%A1%A8%E5%B1%95%E7%A4%BA%EF%BC%89)

#### **四. 三级城市列表使用方法**
[样式四链接-三级城市列表使用方法](https://github.com/crazyandcoder/citypicker/wiki/%E6%A0%B7%E5%BC%8F%E4%B8%89%EF%BC%88%E7%9C%81%E5%B8%82%E5%8C%BA%E4%B8%89%E7%BA%A7%E5%88%97%E8%A1%A8%EF%BC%89)


#### **gradle引用**

```
compile 'liji.library.dev:citypickerview:4.3.0'
```

#### **代码混淆**

```
#地区3级联动选择器

-keep class com.lljjcoder.**{
	*;
}

-dontwarn demo.**
-keep class demo.**{*;}
-dontwarn net.sourceforge.pinyin4j.**
-keep class net.sourceforge.pinyin4j.**{*;}
-keep class net.sourceforge.pinyin4j.format.**{*;}
-keep class net.sourceforge.pinyin4j.format.exception.**{*;}

```

### **更新说明**

#### **V4.3.0版本更新内容（2019.06.27）**
1. 发布4.3.0版本,京东选择器样式新增设置显示“省市两级和省市区三级”样式的属性。


[历史更新说明](https://github.com/crazyandcoder/citypicker/wiki/%E5%8E%86%E5%8F%B2%E6%9B%B4%E6%96%B0%E8%AE%B0%E5%BD%95)



### **特别说明**
感谢[small-dream](https://github.com/small-dream/China_Province_City)提供的获取城市数据的脚本源码

### **专属QQ群，欢迎加入！**

QQ群：417846442


### **其他问题wiki**

https://github.com/crazyandcoder/citypicker/wiki

### **赞赏**

如果你喜欢 citypicker 这个开源库，感觉 citypicker 帮助到了你，可以点右上角 "Star" 支持一下 谢谢！,你也还可以扫描下面的二维码~ 请作者喝一杯牛奶，让作者更有动力写出更好的开源库服务大家。^_^ 


 ![](http://img.blog.csdn.net/20180102115819490?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)              ![](http://img.blog.csdn.net/20180102115834628?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 
 
 
**赞赏的伙计，请注明你们的昵称，请留下你们的联系方式(最好是GitHub地址)，谢谢合作 ^_^ 。**
 
 


 
