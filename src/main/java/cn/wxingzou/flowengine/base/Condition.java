package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.result.Result;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 13:16
 */
public interface Condition<T> {

    Result check(T t);

    String getDescription();

}
