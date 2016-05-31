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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：UtilsLib
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/25 16:29
 * 类描述：Json操作的相关工具类，底层使用的是Gson，禁止实例化该类
 */
public class JsonUtil {
    private static final String TAG = "JsonUtil";

    /**
     * 禁止实例化该类
     */
    private JsonUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    /**
     * 把一个map变成json字符串
     *
     * @param map 封装了数据的map集合
     * @return 数据对应的Json字符串形式
     */
    public static String parseMapToJson(Map<?, ?> map) {
        try {
            Gson gson = new Gson();
            return gson.toJson(map);
        } catch (Exception e) {
            LogUtil.log(TAG, e);
        }
        return "";
    }


    /**
     * 将一个json字符串转换成指定的JavaBean对象
     *
     * @param json 需要转换的json字符串
     * @param cls  json字符串对应的JavBean
     * @param <T>  指定的数据类型
     * @return 封装好数据的JavaBean对象
     */
    public static <T> T jsonToBean(String json, Class<T> cls) {
        Gson gson = new Gson();
        T t = null;
        try {
            t = gson.fromJson(json, cls);
        } catch (Exception e) {
            LogUtil.log(TAG, e);
        }
        return t;
    }

    /**
     * 把json字符串变成map形式
     *
     * @param json 需要转换的Json
     * @return map封装的数据
     */
    public static HashMap<String, Object> parseJsonToMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> map = null;
        try {
            map = gson.fromJson(json, type);
        } catch (Exception e) {
            LogUtil.log(TAG, e);
        }
        return map;
    }


    /**
     * 把json字符串变成集合<br>
     * 参数示例：new TypeToken&lt;List&lt;YourBean&gt;&gt;(){}.getType()
     *
     * @param json 需要转换的Json字符串
     * @param type 示例：new TypeToken&lt;List&lt;YourBean&gt;&gt;(){}.getType()
     * @return 数据集合
     */
    public static List<?> parseJsonToList(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    /**
     * 获取json串中某个字段的值，注意，只能获取同一层级的value
     *
     * @param json json字符串
     * @param key  json中下一级的bean
     * @return key对应的值
     */
    public static String getFieldValue(String json, String key) {
        if (TextUtils.isEmpty(json))
            return null;
        if (!json.contains(key))
            return "";
        JSONObject jsonObject;
        String value = null;
        try {
            jsonObject = new JSONObject(json);
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            LogUtil.log(TAG, e);
        }
        return value;
    }

}
