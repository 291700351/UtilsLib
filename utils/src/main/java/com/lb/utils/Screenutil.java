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
import android.view.WindowManager;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 17:27
 * 类描述：屏幕相关的工具类，提供静态方法调用禁止实例化该类
 */
public class Screenutil {
    //===Desc:构造函数==========================================================================================

    private Screenutil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:提供给外界调用的静态方法==========================================================================================

    /**
     * 根据屏幕密度，将一个dp值转换成对应的px值
     *
     * @param context 上下文对象
     * @param dp      需要转换的dp值
     * @return dp值对应的px值
     */
    public static int dp2px(Context context, float dp) {
        return (int) (0.5F + context.getResources().getDisplayMetrics().density * dp);
    }

    /**
     * 将一个px转换成dp值
     *
     * @param context 上下文对象
     * @param px      需要转换的px值
     * @return px对应的dp值
     */
    public static int px2dip(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 获取封装屏幕宽高的Screen对象
     *
     * @param context 上下文对象
     * @return 封装尺寸的对象
     */
    public static Screen getScreenSize(Context context) {
        Screen screen = new Screen();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        screen.width = wm.getDefaultDisplay().getWidth();
        screen.height = wm.getDefaultDisplay().getHeight();
        return screen;
    }

    /**
     * 项目名称：UtilsLib
     * 作者：lb291
     * 邮箱： lb291700351@live.cn
     * 时间：2016/5/25 17:27
     * 类描述：封装屏幕宽高的对象
     */
    public static class Screen {
        /**
         * 屏幕的宽度
         */
        public int width;
        /**
         * 屏幕的高度
         */
        public int height;
    }

}
