#框架优点

可能是性能最优、使用最简单，支持自定义，不需要通知栏权限的吐司

无需权限：不管有没有授予通知栏权限都不影响吐司的弹出

功能强大：不分主次线程都可以弹出Toast，自动区分资源id和int类型

使用简单：只需传入文本，会自动根据文本长度决定吐司显示的时长

性能最佳：单例吐司，整个Toast只有一个TextView，并且通过代码创建

体验最优：限制Toast短时间内弹出的次数，避免频繁弹出造成不良的用户体验

支持多种样式：默认为黑色样式，夜间模式可使用白色样式，还有仿QQ吐司样式

支持自定义样式：吐司（背景、圆角、重心、偏移），文字（大小、颜色、边距）

支持自定义扩展：支持获取ToastUtils中的Toast对象，支持重新自定义Toast布局

支持全局配置样式：可以在Application中初始化Toast样式，达到一劳永逸的效果

框架兼容性良好：本框架不依赖任何第三方库，支持Eclipse和Studio的集成使用

可任意拦截: 可以提前设置后需要拦截的文本，避免在使用中出现不应该显示的内容

#环境集成
在项目根目录下的 build.gradle 文件中加入
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

#在项目 app 模块下的 build.gradle 文件中加入
android {
    // 支持 JDK 1.8
    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
        sourceCompatibility JavaVersion.VERSION_1_8
    }
}


#使用方法

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