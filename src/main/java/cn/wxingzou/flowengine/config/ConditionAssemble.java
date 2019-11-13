package cn.wxingzou.flowengine.config;

import cn.wxingzou.flowengine.base.ConditionChainContext;

import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:56
 **/
public interface ConditionAssemble {

    ConcurrentMap<String, ConditionChainContext> createConditionChain();

}
