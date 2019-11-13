package cn.wxingzou.flowengine.util;

import java.util.Objects;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 15:43
 **/
public class Assert {


    public static void notnull(Object obj, String argName) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(argName + " cannot be null");
        }
    }

    public static void notEmpty(String arg, String argName) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(argName + " cannot be empty");
        }
    }

    public static void notTrue(boolean flag, String message) {
        if (flag) {
            throw new IllegalArgumentException(message);
        }
    }


}
