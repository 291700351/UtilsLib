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

import android.text.TextUtils;
import android.util.Log;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 14:33
 * 类描述：打印日志的相关工具类，提供静态方法使用，禁止实例化该类
 */
public class LogUtil {
    private static String TAG = "LogUtil";

    /**
     * 打印日志级别的枚举
     */
    public enum Level {
        /**
         * v级别的日志
         */
        v(0),
        /**
         * d级别的日志
         */
        d(1),
        /**
         * i级别的日志
         */
        i(2),
        /**
         * w级别的日志
         */
        w(3),
        /**
         * e级别的日志
         */
        e(4);

        private int value;

        public int getValue() {
            return value;
        }

        private Level(int value) {
            this.value = value;
        }

    }

    /**
     * 默认的日志级别是e级别的
     */
    private static Level mLevel = Level.e;

    /**
     * 是否是Debug模式，可以在全局的application中设置是否打印日志。
     * true:会打印日志。false:不答应日志
     */
    public static boolean isDebug = true;

    /**
     * 在应用程序的Application里面调用该方法设置是否是Debug模式和日志打印界别，默认级别是e级别
     *
     * @param debug 是否是debug模式
     * @param level 日志级别
     */
    public static void initLog(boolean debug, Level level) {
        isDebug = debug;
        mLevel = level;
    }

    /**
     * 禁止实例化该类
     */
    private LogUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:打印e级别日志==========================================================================================

    /**
     * 打印一条e级别的日志
     *
     * @param tag Tag
     * @param msg 需要打印的信息
     */
    public static void e(String tag, String msg) {
        if (isDebug) {
            if (TextUtils.isEmpty(tag))
                tag = TAG;
            if (TextUtils.isEmpty(msg))
                msg = "Your print msg is null or \"\",please check your msg first !";
            Log.e(tag, msg);
        }
    }

    /**
     * 打印一条e级别的日志
     *
     * @param tag Tag
     * @param msg 需要打印的信息
     */
    public static void e(Object tag, String msg) {
        if (null == tag)
            e(null, msg);
        else
            e(tag.getClass().getSimpleName(), msg);

    }

    /**
     * 打印一条e级别的日志
     *
     * @param tag Tag
     * @param msg 需要打印的信息
     */
    public static void e(Object tag, Object msg) {
        e(tag, String.valueOf(msg));
    }

    //===Desc:log方法===============================================================================================

    /**
     * 根据当前设置的日志界别打印日志
     *
     * @param tag TAG
     * @param msg 需要打印的信息
     */
    public static void log(String tag, String msg) {
        if (isDebug) {
            if (TextUtils.isEmpty(tag))
                tag = TAG;
            if (TextUtils.isEmpty(msg))
                msg = "Your print msg is null or \"\",please check your msg first !";
            switch (mLevel.getValue()) {
                case 0://v级别
                    Log.v(tag, msg);
                    break;
                case 1://d级别
                    Log.d(tag, msg);
                    break;
                case 2://i级别
                    Log.i(tag, msg);
                    break;
                case 3://w级别
                    Log.w(tag, msg);
                    break;
                case 4://e级别
                    Log.e(tag, msg);
                    break;
            }
        }

    }

    /**
     * 根据当前设置的日志界别打印日志
     *
     * @param tag Tag
     * @param msg 需要打印的信息
     */
    public static void log(Object tag, String msg) {
        if (null == tag)
            log(null, msg);
        else
            log(tag.getClass().getSimpleName(), msg);

    }

    /**
     * 根据当前设置的日志界别打印日志
     *
     * @param tag Tag
     * @param msg 需要打印的信息
     */
    public static void log(Object tag, Object msg) {
        log(tag, String.valueOf(msg));
    }


}
