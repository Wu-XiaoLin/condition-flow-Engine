package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.allocation.ConditionAssemble;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 11:28
 **/
public interface ConfigurableFlowExecuteContext extends FlowTemplate, ConditionAssemble, ConditionChainOwner {

    void refresh();

}
