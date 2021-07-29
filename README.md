# 我的理念概述
我的理念的是能用一行代码解决的是，绝对不用两行
其实编写依赖库的目的就是将一个功能尽可能的完善
代码调用方便，简洁
# 开发原因
Toast是我们在日常开发中非常重要的一个使用api,但是在我们公司开发到android 9.0的时候，在之前正常运行的项目中Toast竟然运行不起来了，具体原因是google在api27的时候对Toast进行了修改。最后使用了自定义吐司的方式将这个问题解决
当我们在子线程使用Toast的时候，会报出异常，这时候我们的操作是将Toast放到loop或者Handle中进行才做，代码编写起来繁琐
于是我就想自己开发一套Toast方便在我们编写代码的时候一步到位的调用
这套框架其实之前之前就已经写出来了，也发现了很多的不足，公司正好有弄组件库的打算，我就将自己写的库分享出来
[LEasyToastTest资源库地址]
[简书地址]（https://www.jianshu.com/p/8a567a3a07cc）

# 框架优点

类型简单：不分主次线程都可以弹出Toast，自动区分资源id和int类型

使用简单：只需传入文本，会自动根据文本长度决定吐司显示的时长（20个字符界限）

性能最佳：单例吐司，整个Toast只有一个TextView，并且通过代码创建

体验最优：限制Toast短时间内弹出的次数，避免频繁弹出造成不良的用户体验

支持多种样式：默认为黑色样式，夜间模式可使用白色样式

支持自定义样式：吐司（背景、圆角、重心、偏移），文字（大小、颜色、边距）

支持自定义扩展：支持获取ToastUtils中的Toast对象，支持重新自定义Toast布局

支持全局配置样式：可以在Application中初始化Toast样式，达到一劳永逸的效果

框架兼容性良好：本框架不依赖任何第三方库，支持Eclipse和Studio的集成使用

可任意拦截: 可以提前设置后需要拦截的文本，避免在使用中出现不应该显示的内容

(https://github.com/freedomangelly/LEasyToastTest)
# 环境集成
```
buildscript {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

```
dependencies {
	        implementation 'com.github.freedomangelly:LEasyToast:0.0.0.1'
	}
```
# 使用方法
在Aplication中进行初始化
```
//在Application中初始化
ToastUtils.init(this);//默认为黑色样式
```

# API
```
//在Application中初始化
ToastUtils.init(this);

//获取Toast对象
ToastUtils.getToast();

//设置自定义吐司
ToastUtils.setView(int id)

//显示Toast
ToastUtils.show("我是吐司");

//取消Toast
ToastUtils.cancel();

//其他API
// 设置 Toast 布局及样式
ToastUtils.setStyle(IToastStyle<?> style);

// 设置 Toast 重心和偏移
ToastUtils.setGravity(int gravity, int xOffset, int yOffset);

// 设置 Toast 拦截器
ToastUtils.setInterceptor(IToastInterceptor interceptor);

// 设置 Toast 策略
ToastUtils.setStrategy(IToastStrategy strategy);

// 设置 Toast 布局
ToastUtils.setView(int id);
```
