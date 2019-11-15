package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.config.AbstractConditionAssembleImpl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 17:24
 **/
public abstract class AbstractConfigableConditionChainOwner extends AbstractConditionAssembleImpl implements ConditionChainOwner {

    /**
     * 存放全局的条件链上下文
     */
    private ConcurrentMap<String, ConditionChainContext> conditionChainHolderMap = new ConcurrentHashMap<String, ConditionChainContext>();

    @Override
    public ConditionChainContext getConditionChain(String type) {
        return conditionChainHolderMap.get(type);
    }

    @Override
    public void setConditionChainMap() {
        //创建条件链
        conditionChainHolderMap = createConditionChain();
    }

}
