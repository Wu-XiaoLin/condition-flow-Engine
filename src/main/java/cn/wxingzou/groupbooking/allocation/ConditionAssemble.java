package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.ConditionConfig;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:56
 **/
public interface ConditionAssemble {

    boolean createConditionChain(List<? extends ConditionConfig> conditionConfigs);

    int conutConditionChainSize();
}
