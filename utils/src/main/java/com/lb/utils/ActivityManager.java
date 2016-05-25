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

import java.util.Stack;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 16:29
 * 类描述：Activity相关的工具,使用单例模式，一个应用程序只允许有一个Activity堆栈的管理工具
 */
public class ActivityManager {
    //===Desc:成员变量======================================================================================
    /**
     * 保存Activity的栈
     */
    private static Stack<Activity> activitys;

    private static ActivityManager am;//当前类的实例，使用的单例模式


    //===Desc:构造函数======================================================================================

    /**
     * 私有化构造函数
     */
    private ActivityManager() {
        if (null == activitys)
            activitys = new Stack<>();
    }

    /**
     * 使用单例模式获取当前类的单一实例
     *
     * @return 当前类的单一实例
     */
    public static synchronized ActivityManager getInstance() {
        if (null == am)
            am = new ActivityManager();
        return am;
    }

    //===Desc:提供给外界使用的静态方法==========================================================================================、

    /**
     * 添加一个Activity到堆栈
     *
     * @param activity 需要添加的Activity对象
     */
    public synchronized void addActivity(Activity activity) {
        activitys.add(activity);
    }

    /**
     * 获取栈顶的Activity
     *
     * @return 如果堆栈中存放有activity，则返回栈顶的Activity对象，如果堆栈中没有存放有activity，则返回null
     */
    public Activity getTopActivity() {
        if (null == activitys || activitys.size() == 0)
            return null;
        return activitys.lastElement();//返回栈里面最后一个元素出去
    }

    /**
     * 关闭存放在堆栈中的Activity
     *
     * @param activity 需要关闭的activity
     */
    public void killActivity(Activity activity) {
        if (null == activity)
            return;
        activitys.remove(activity);
        activity.finish();
    }

    /**
     * 关闭栈顶的Activity
     */
    public void killTopActivity() {
        Activity topActivity = getTopActivity();
        killActivity(topActivity);
    }

    /**
     * 关闭指定名字的activity
     *
     * @param cls Activity的class对象
     */
    public void killActivity(Class<?> cls) {
        for (Activity activity : activitys) {
            if (activity.getClass().equals(cls))
                killActivity(activity);
        }
    }

    /**
     * 关闭存放在堆栈中所有的activity
     */
    public void killAllActivity() {
        for (Activity a : activitys) {
            if (null != a) {
                a.finish();
            }
        }
        activitys.clear();//清空堆栈
    }


}
