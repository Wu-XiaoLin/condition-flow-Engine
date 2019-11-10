package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.result.FailReason;
import cn.wxingzou.groupbooking.result.Result;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 13:16
 */
public interface Condition<T> {


    Result test(T t);

    FailReason fail();

    String getDescription();

}
