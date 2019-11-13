package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.config.ConditionAssemble;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 10:54
 **/
public interface ConfigutableConditionChainOwner extends ConditionChainOwner, ConditionAssemble {

    void init();
}
