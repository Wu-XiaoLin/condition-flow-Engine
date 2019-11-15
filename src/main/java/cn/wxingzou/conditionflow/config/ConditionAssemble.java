package cn.wxingzou.conditionflow.config;

import cn.wxingzou.conditionflow.core.ConditionChainContext;

import java.util.concurrent.ConcurrentMap;

/**
 * 抽象条件组装加载
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:56
 **/
public interface ConditionAssemble {

    /**
     * 创建应用内条件链上下文
     * @return
     */
    ConcurrentMap<String, ConditionChainContext> createConditionChain();

}
