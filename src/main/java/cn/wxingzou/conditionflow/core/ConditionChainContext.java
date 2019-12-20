package cn.wxingzou.conditionflow.core;

import java.util.Iterator;
import java.util.Map;

/**
 * 条件链上下文
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 12:25
 */
public interface ConditionChainContext {

    /**
     * 条件链类型
     *
     * @return
     */
    String getType();

    /**
     * 添加条件
     *
     * @param condition
     */
    void addCondition(Condition condition);

    /**
     * 获取条件数量
     *
     * @return
     */
    int getConditionSize();

    /**
     * 获取某个位置的条件
     *
     * @param index
     * @return
     */
    Condition getCondition(int index);

    /**
     * 转为迭代器
     *
     * @return
     */
    Iterator<Condition> iterator();

    /**
     * 获取条件链的全部条件描述
     *
     * @return
     */
    String getConditionChainStr();

    /**
     * 获取条件链的描述
     *
     * @return
     */
    String getConditionChainDescription();

    /**
     * 获取条件链需要的全部预置参数
     *
     * @return
     */
    Map<String, Object> getProperties();
}
