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
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 14:49
 * 类描述：显示Toast的工具类，提供静态方法调用，禁止实例化该类
 */
public class ToastUtil {

    //===Desc:成员变量==========================================================================================
    /**
     * 默认的TAG信息
     */
    private static final String TAG = "ToastUtil";
    private static Toast toast;

    //===Desc:构造函数==========================================================================================

    /**
     * 禁止实例化该类
     */
    private ToastUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:提供给外界使用的方法==========================================================================================

    /**
     * 根据isLong显示一个长时间的Toast或者短时间的Toast
     *
     * @param context Context对象
     * @param text    需要Toast显示的信息
     * @param isLong  是否是长时间的Toast，true：长时间。false：短时间的Toast
     */
    public static void showToastByIslong(Context context, String text, boolean isLong) {
        if (TextUtils.isEmpty(text)) {
            LogUtil.e(TAG, "The Toast show text is null or \"\"!");
            return;
        }
        if (null == toast) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        if (isLong)
            toast.setDuration(Toast.LENGTH_LONG);
        else
            toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText(text);
        toast.show();
    }

    /**
     * 显示一个短时间的Toast信息
     *
     * @param context Context对象
     * @param text    需要显示的文本信息
     */
    public static void showShortToast(Context context, String text) {
        showToastByIslong(context, text, false);
    }

    /**
     * 显示一个长时间的Toast信息
     *
     * @param context Context对象
     * @param text    需要Toast显示的信息
     */
    public static void showLongToast(Context context, String text) {
        showToastByIslong(context, text, true);
    }
}
