//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
package com.lb.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 17:57
 * 类描述：于应用程序相关的工具类，提供静态方法调用，禁止实例化该类
 */
public class ApplicationUtil {
    //===Desc:成员变量======================================================================================
    private static final String TAG = "ApplicationUtil";

    //===Desc:构造函数======================================================================================

    /**
     * 禁止实例化该类
     */
    private ApplicationUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:提供给外界使用的静态方法======================================================================================

    /**
     * 获取应用程序的版本名称
     *
     * @param context 上下文对象
     * @return 程序对应的本本名称，用于显示当前版本
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();// 获取包的管理者
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;// 获取应用程序的版本名称
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(TAG, e);
        }
        return "";
    }

    /**
     * 获取应用程序的内部版本号
     *
     * @param context 上下文对象
     * @return 程序的内部版本号，用于比对升级用
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();// 获取包的管理者
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionCode;// 获取应用程序的版本名称
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(TAG, e);
        }
        return 0;
    }

}
