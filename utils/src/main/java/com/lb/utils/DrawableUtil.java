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

import android.graphics.drawable.GradientDrawable;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 15:38
 * 类描述：Drawable相关的工具类，提供静态方法调用，禁止实例化该类
 */
public class DrawableUtil {
    //===Desc:成员变量======================================================================================

    //===Desc:构造函数======================================================================================

    /**
     * 禁止实例化该类
     */
    private DrawableUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:提供给外籍调用的方法==========================================================================================
    //===Desc:代码创建矩形==========================================================================================

    /**
     * 使用代码创建指定圆角大小的矩形shape形状
     *
     * @param rgb               形状颜色
     * @param topLeftRadius     左上角的圆角尺寸
     * @param topRightRadius    右上角的圆角尺寸
     * @param bottomLeftRadius  左下角的圆角尺寸
     * @param bottomRightRadius 右下角的圆角尺寸
     * @return 指定形状的Drawable对象
     */
    public static GradientDrawable createRectangleDrawable(int rgb, float topLeftRadius, float topRightRadius,
                                                           float bottomLeftRadius, float bottomRightRadius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);//设置矩形
        //创建圆角
        float[] radius = {
                topLeftRadius, topLeftRadius,
                topRightRadius, topRightRadius,
                bottomRightRadius, bottomRightRadius,
                bottomLeftRadius, bottomLeftRadius};
        drawable.setCornerRadii(radius);
        drawable.setColor(rgb);
        return drawable;
    }

    /**
     * 创建一个没有圆角的指定颜色的矩形Drawble
     *
     * @param rgb 矩形形状的颜色
     * @return 指定颜色的矩形的Drawanle对象
     */
    public static GradientDrawable createRectangleDrawable(int rgb) {
        return createRectangleDrawable(rgb, 0, 0, 0, 0);
    }

//    //===Desc:代码创建椭圆形==========================================================================================
////    GradientDrawable.OVAL
//
//    public static GradientDrawable createOvalDrawable(int rgb) {
//        GradientDrawable drawable = new GradientDrawable();
//        drawable.setShape(GradientDrawable.OVAL);//设置椭圆形
//        drawable.set
//        drawable.setColor(rgb);
//        return drawable;
//    }

}
