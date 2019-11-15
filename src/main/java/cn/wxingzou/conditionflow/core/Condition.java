package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.result.Result;

/**
 * 条件定义
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 13:16
 */
public interface Condition<T> {

    /**
     * 执行条件内的检查
     *
     * @param t 入参自己定义
     * @return
     */
    Result check(T t);

    /**
     * 获取条件的描述
     * @return
     */
    String getDescription();

}
