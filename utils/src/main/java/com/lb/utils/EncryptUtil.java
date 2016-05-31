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

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

/**
 * 项目名称：ysp-android
 * 作者：IceLee
 * 邮箱：lb291700351@live.cn
 * 时间：2016/5/28 19:46
 * 类描述：Java数据加密相关的工具类,禁止实例化该类，目前提供Md5加密，Des加密解密
 */
public class EncryptUtil {
    private static final String TAG = "EncryptUtil";

    /**
     * 禁止实例化该类
     */
    private EncryptUtil() {
        throw new UnsupportedOperationException(
                "The class " + getClass().getSimpleName() + " can not be instantiated!");
    }

    //===Desc:提供给外界使用的方法===============================================================================================

    //===Desc:MD5加密===============================================================================================

    /**
     * 使用MD5加密字符串，数据不可逆
     *
     * @param data 需要加密的字符串数据
     * @return Md5加密之后的字符串形式
     */
    public static String md5(String data) {
        StringBuilder sb = new StringBuilder();
        try {
            //数据摘要器
            //参数：加密的方式
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //把一个byte数组进行加密，返回的是一个加密过的byte数组
            byte[] digests = messageDigest.digest(data.getBytes());
            //遍历digest
            for (byte digest : digests) {
                int result = digest & 0xff;
                //将int类型的数据转化成十六进制的字符串
//				String hexString = Integer.toHexString(result)+1;//不规则加密，加盐
                String hexString = Integer.toHexString(result);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //找不到加密方式的异常
            LogUtil.e(TAG, e);
        }
        return "";
    }

    //===Desc:Des加密===============================================================================================

    /**
     * 使用指定的key对数据进行Des加密
     *
     * @param key  加密的密钥
     * @param data 要加密的明码
     * @return 加密后的暗码, 加密失败返回空字符串
     */
    public static String desEncrypt(String key, String data) {
        try {
            DESPlus desPlus = new DESPlus(key);
            return desPlus.encrypt(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 使用指定的key解密进行过Des加密的数据
     *
     * @param key         解密的key
     * @param decryptData des加密的字符串
     * @return 未加密的数据字符串 解密失败返回空字符串
     */
    public static String desDecrypt(String key, String decryptData) {
        try {
            DESPlus desPlus = new DESPlus(key);
            return desPlus.decrypt(decryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    //===Desc:Des处理类===============================================================================================


    /**
     * DES 处理类
     */
    private static class DESPlus {

        private Cipher encryptCipher = null;

        private Cipher decryptCipher = null;

        /**
         * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
         * hexStr2ByteArr(String strIn) 互为可逆的转换过程
         *
         * @param arrB 需要转换的byte数组
         * @return 转换后的字符串
         * @throws Exception 本方法不处理任何异常，所有异常全部抛出
         */
        public String byteArr2HexStr(byte[] arrB) throws Exception {
            int iLen = arrB.length;
            // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
            StringBuffer sb = new StringBuffer(iLen * 2);
            for (byte anArrB : arrB) {
                int intTmp = anArrB;
                // 把负数转换为正数
                while (intTmp < 0) {
                    intTmp = intTmp + 256;
                }
                // 小于0F的数需要在前面补0
                if (intTmp < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toString(intTmp, 16));
            }
            return sb.toString();
        }

        /**
         * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
         * 互为可逆的转换过程
         *
         * @param strIn 需要转换的字符串
         * @return 转换后的byte数组
         * @throws Exception 本方法不处理任何异常，所有异常全部抛出
         */
        public byte[] hexStr2ByteArr(String strIn) throws Exception {
            byte[] arrB = strIn.getBytes();
            int iLen = arrB.length;
            // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
            byte[] arrOut = new byte[iLen / 2];
            for (int i = 0; i < iLen; i = i + 2) {
                String strTmp = new String(arrB, i, 2);
                arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
            }
            return arrOut;
        }

        /**
         * 指定密钥构造方法
         *
         * @param strKey 指定的密钥
         * @throws Exception
         */
        public DESPlus(String strKey) throws Exception {
            Key key = getKey(strKey.getBytes());
            encryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            decryptCipher = Cipher.getInstance("DES");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
        }

        /**
         * 加密字节数组
         *
         * @param arrB 需加密的字节数组
         * @return 加密后的字节数组
         * @throws Exception
         */
        public byte[] encrypt(byte[] arrB) throws Exception {
            return encryptCipher.doFinal(arrB);
        }

        /**
         * 加密字符串
         *
         * @param strIn 需加密的字符串
         * @return 加密后的字符串
         * @throws Exception
         */
        public String encrypt(String strIn) throws Exception {
            return byteArr2HexStr(encrypt(strIn.getBytes()));
        }

        /**
         * 解密字节数组
         *
         * @param arrB 需解密的字节数组
         * @return 解密后的字节数组
         * @throws Exception
         */
        public byte[] decrypt(byte[] arrB) throws Exception {
            return decryptCipher.doFinal(arrB);
        }

        /**
         * 解密字符串
         *
         * @param strIn 需解密的字符串
         * @return 解密后的字符串
         * @throws Exception
         */
        public String decrypt(String strIn) throws Exception {
            return new String(decrypt(hexStr2ByteArr(strIn)), "UTF-8");
        }

        /**
         * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
         *
         * @param arrBTmp 构成该字符串的字节数组
         * @return 生成的密钥
         * @throws java.lang.Exception
         */
        private Key getKey(byte[] arrBTmp) throws Exception {
            // 创建一个空的8位字节数组（默认值为0）
            byte[] arrB = new byte[8];

            // 将原始字节数组转换为8位
            for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
                arrB[i] = arrBTmp[i];
            }

            // 生成密钥
            return new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        }

    }


}

