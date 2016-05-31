#一些Android开发常用的工具方法的封装

###AndroidStudio引入
    dependencies {
        compile 'com.lb:utils:1.0.1'
    }

*NODE:*
## 新增EncryptUtil类,数据加密的工具类，禁止实例化该类对象
- 提供MD5数据加密
- 提供Des数据加密、解密方法

*LogUtil新增指定日志级别*
- 在应用程序的Application中调用LogUtil.initLog()方法指定是否是Debug模式和使用的Log级别

    LogUtil.log("TAG", "msg");
    LogUtil.log(obj, "msg");
    LogUtil.log(obj, obj);
<hr/>    
##ActivityManager
**Activity管理的工具类，使用栈管理开启的Activity，单例模式**

    ActivityManager.getInstance().addActivity(Activity activity);//添加一个Activity
    ActivityManager.getInstance().getTopActivity();//获取栈顶的Activity
    ActivityManager.getInstance().killActivity(Activity activity);//关闭指定的Activity
    ActivityManager.getInstance().killTopActivity();//关闭栈顶的Activity
    ActivityManager.getInstance().killActivity(Class<?> cls);//关闭指定的Activity
    ActivityManager.getInstance().killAllActivity();//关闭所有已经被管理的Activity
    
##ApplicationUtil
**与Application相关的工具，提供静态方法调用，禁止实例化该类**

    ApplicationUtil.getVersionName(context);//获取应用程序的外部版本号
    ApplicationUtil.getVersionCode(context);//获取应用程序的内部版本号，可用于版本升级判断等
    
##CacheUtil
**SharedPreferences缓存数据，缓存数据都经过AES加密处理，避免明文缓存数据**

##DrawableUtil
**使用代码创建Drawable形状**

    DrawableUtil.createRectangleDrawable();//创建指定圆角、指定颜色的矩形
    DrawableUtil.createRectangleDrawable(rgb);//创建指定颜色,没有圆角的矩形
    
##SelectorUtil
**使用代码创建空间的状态选择器，可以配合DrawableUtil使用，完全使用Java代码创建控件的Selector，禁止实例化该类**

    SelectorUtil.createNormalAndPressedSelector();//创建正常状态和按下状态的选择器
    SelectorUtil.createSelectorByStates();//根据指定的状态创建选择器，参数使用LinkedHashMap，因为状态选择器有先后顺序
    
##LogUtil
**Log日志相关的工具类，禁止实例化**

Log日志级别目前只有e级别的，默认是Debug状态的，可以在你应用程序的Application中调用LogUtil.isDebug = false设置是否是Debug模式，
正式打包发版前，可以使用这个方式关闭日志打印

    LogUtil.e("TAG","msg");
    LogUtil.e(obj,"msg");
    LogUtil.e(obj,obj);
    
##Screenutil
**屏幕相关的工具类，主要是针对尺寸相关，禁止实例化**
    
    Screenutil.dp2px();//dp转换成px
    Screenutil.px2dp();//px转换成dp
    Screenutil.getScreenSize();//获取屏幕宽高
    
##SdCardUtil
**sd卡相关的工具类**

    SdCardUtil.sdCardEnable();//判断sd卡是否可用
    SdCardUtil.getSDCardPath();//获取sd卡绝对路径
    SdCardUtil.getSDCardAllSize();//获取sd卡大小
    SdCardUtil.getFreeBytes();//获取指定路径的空闲空间大小
    SdCardUtil.getRootDirectoryPath();//获取系统存储路径的绝对路径

##ToastUtil
**显示Toast相关的工具类**

使用挺简单，不用示例

##ViewUtil
**使用该工具类主要是初始化控件，不用每次都去强制类型转换**

    //免去每次findViewById之后进行控件的强制类型转换
    TextView tv = ViewUtil.findViewById(activity,R.id.tv);
    TextView tv = ViewUtil.findViewById(view,R.id.tv);

