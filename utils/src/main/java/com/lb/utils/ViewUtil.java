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

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 15:02
 * 类描述：findViewById的工具类，提供静态方法调用，禁止实例化该类
 */
public class ViewUtil {
    //===Desc:构造函数======================================================================================

    /**
     * 禁止实例化该类
     */
    private ViewUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }
    //===Desc:提供给外界使用的方法==========================================================================================

    /**
     * activity中通过Id获取控件的方法，根据声明的控件类型强制类型转换
     *
     * @param activity 控件所在的activity
     * @param resId    控件的id
     * @param <E>      继承自View的控件类型
     * @return 控件声明的类型
     */
    public static <E extends View> E findViewById(Activity activity, @IdRes int resId) {
        //noinspection unchecked
        return (E) activity.findViewById(resId);
    }

    /**
     * activity中通过Id获取控件的方法，根据声明的控件类型强制类型转换
     *
     * @param view  控件所在的View对象
     * @param resId 控件的id
     * @param <E>   继承自View的控件类型
     * @return 控件声明的类型
     */
    public static <E extends View> E findViewById(View view, @IdRes int resId) {
        if (null == view)
            throw new IllegalArgumentException(
                    "The argument view can not be null,please check your argument!");
        //noinspection unchecked
        return (E) view.findViewById(resId);
    }

}
