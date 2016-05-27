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

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 16:05
 * 类描述：代码生产状态选择器，该类可以结合DrawableUtil生成的Drawable对象使用.提供静态方法调用，禁止实例化该类
 */
public class SelectorUtil {

    //===Desc:构造函数==========================================================================================

    /**
     * 禁止实例化该类
     */
    private SelectorUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }
    //===Desc:提供给外界调用的静态方法==========================================================================================

    /**
     * 创建一个按下和正常状态的选择器
     *
     * @param normal  正常状态的Drawable对象
     * @param pressed 按下状态的Drawable对象
     * @return 按下和转产状态的状态选择器
     */
    public static StateListDrawable createNormalAndPressedSelector(Drawable normal, Drawable pressed) {
        LinkedHashMap<int[], Drawable> states = new LinkedHashMap<>();
        states.put(new int[]{android.R.attr.state_pressed}, pressed);
        states.put(new int[]{}, normal);
        return createSelectorByStates(states);
    }

    /**
     * 根据map里面创建选择器
     *
     * @param states 封装了状态对应的Drawable对象的集合，状态选择器是有前后顺序的，所以请使用LinkedHashMap
     * @return map中的选择器
     */
    public static StateListDrawable createSelectorByStates(LinkedHashMap<int[], Drawable> states) {
        //如果map里面的状态小于2个，就不能生成选择器
        if (null == states || states.size() < 2) {
            throw new IllegalStateException("You must make 2 state to create seletor!");
        }
        //创建选择器对象
        StateListDrawable stateListDrawable = new StateListDrawable();
        //遍历集合
        Set<Map.Entry<int[], Drawable>> set = states.entrySet();
        for (Map.Entry<int[], Drawable> next : set) {
            int[] state = next.getKey();
            LogUtil.e(null, state.length);
            Drawable drawable = next.getValue();
            //给选择器添加对应的状态
            stateListDrawable.addState(state, drawable);
        }
        return stateListDrawable;
    }
}
