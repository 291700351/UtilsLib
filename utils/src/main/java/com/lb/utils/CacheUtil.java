package com.lb.utils;


import android.content.Context;

import com.lb.utils.securepreferences.SecurePreferences;

/**
 * 缓存的工具类
 *
 * @author xiaofuweng
 */
public class CacheUtil {

    /**
     * 禁止实例化该对象
     */
    private CacheUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    private static SecurePreferences sp;


    /**
     * 保存数据到sp中
     *
     * @param context 上下文对象
     * @param key     键
     * @param value   值
     */
    public static void put(Context context, String key, Object value) {
        if (null == sp)
            sp = new SecurePreferences(context);

        SecurePreferences.Editor edit = sp.edit();
        //根据传递的value存放不同的值
        if (value instanceof String) {
            edit.putString(key, String.valueOf(value));
        } else if (value instanceof Boolean) {
            boolean v = (boolean) value;
            edit.putBoolean(key, v);
        } else if (value instanceof Float) {
            float v = (float) value;
            edit.putFloat(key, v);
        } else if (value instanceof Integer) {
            int v = (int) value;
            edit.putInt(key, v);
        } else if (value instanceof Long) {
            long v = (long) value;
            edit.putLong(key, v);
        }
        edit.commit();
    }


    /**
     * 从sp中获取一个缓存的数据
     *
     * @param context  上下文对象
     * @param key      缓存的键名
     * @param defValue 没在缓存中找到使用的默认值
     * @return 缓存在sp中对应的数据类型
     */
    public static Object get(Context context, String key, Object defValue) {
        if (null == sp)
            sp = new SecurePreferences(context);

        if (defValue instanceof String) return sp.getString(key, (String) defValue);
        else if (defValue instanceof Boolean) return sp.getBoolean(key, (Boolean) defValue);
        else if (defValue instanceof Float) return sp.getFloat(key, (Float) defValue);
        else if (defValue instanceof Integer) return sp.getInt(key, (Integer) defValue);
        else if (defValue instanceof Long) return sp.getLong(key, (Long) defValue);
        else return null;
    }

    //===Desc:String类型==========================================================================================

    public static void putString(Context context, String key, String value) {
        put(context, key, value);
    }

    /**
     * 从sp中获取String
     *
     * @param context  上下文对象
     * @param key      键
     * @param defValue 默认值
     * @return sp中的值
     */
    public static String getString(Context context, String key, String defValue) {
        return (String) get(context, key, defValue);
    }

    //===Desc:int类型==========================================================================================

    /**
     * 缓存一个int类型的数据
     *
     * @param context 上下文对象
     * @param key     储存的键名
     * @param value   储存的值
     */
    public static void putInt(Context context, String key, int value) {
        put(context, key, value);
    }

    /**
     * 从缓存中获取一个int，没有缓存就使用传入的默认值
     *
     * @param context  上下文对象
     * @param key      存储的键名
     * @param defValue 默认值
     * @return 如果sp中缓存了该值就使用  否则返回默认值
     */
    public static int getInt(Context context, String key, int defValue) {
        return (int) get(context, key, defValue);
    }
    //===Desc:boolean类型==========================================================================================

    /**
     * 缓存boolean类型
     *
     * @param context 上下文对象
     * @param key     储存的键名
     * @param value   储存的值
     */
    public static void putBoolean(Context context, String key, boolean value) {
        put(context, key, value);
    }

    /**
     * 获取黄埙的boolean值
     *
     * @param context  上下文对象
     * @param key      键名
     * @param defValue 默认值
     * @return 拿不到就使用默认值
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return (boolean) get(context, key, defValue);
    }

    //===Desc:float类型==========================================================================================

    /**
     * 件一个float类型的值缓存到sp中
     *
     * @param context 上下文对象
     * @param key     缓存的键
     * @param value   换出的值
     */
    public static void putFloat(Context context, String key, float value) {
        put(context, key, value);
    }

    /**
     * 从sp缓存中获取一个float类型的值
     *
     * @param context  上下文对象
     * @param key      缓存的键
     * @param defValue 如果取值娶不到使用默认的值
     * @return sp中缓存的值
     */
    public static float getFloat(Context context, String key, float defValue) {
        return (float) get(context, key, defValue);
    }

    //===Desc:long类型==========================================================================================

    /**
     * 件一个long类型的值缓存到sp中
     *
     * @param context 上下文对象
     * @param key     缓存的键
     * @param value   换出的值
     */
    public static void putFloat(Context context, String key, long value) {
        put(context, key, value);
    }

    /**
     * 从sp缓存中获取一个long类型的值
     *
     * @param context  上下文对象
     * @param key      缓存的键
     * @param defValue 如果取值娶不到使用默认的值
     * @return sp中缓存的值
     */
    public static long getFloat(Context context, String key, long defValue) {
        return (long) get(context, key, defValue);
    }


}
