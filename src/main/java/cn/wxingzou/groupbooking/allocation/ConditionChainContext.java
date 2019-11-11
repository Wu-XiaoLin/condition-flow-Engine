package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.Condition;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 12:25
 */
public interface ConditionChainContext {

    String getType();

    void addCondition(Condition condition);

    int getConditionSize();

    String getConditionChainStr();

    String getConditionChainDescription();
}
