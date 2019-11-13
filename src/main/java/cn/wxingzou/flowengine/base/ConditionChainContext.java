package cn.wxingzou.flowengine.base;

import java.util.Iterator;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 12:25
 */
public interface ConditionChainContext {

    String getType();

    void addCondition(Condition condition);

    int getConditionSize();

    Condition getCondition(int index);

    Iterator<Condition> iterator();

    String getConditionChainStr();

    String getConditionChainDescription();
}
