package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.allocation.ConditionAssembleImpl;
import cn.wxingzou.groupbooking.allocation.ConditionChainContext;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 17:56
 **/
public class ConfigurableFlowExecuteContextImpl extends ConditionAssembleImpl implements ConfigurableFlowExecuteContext {
    @Override
    public void execute(String type) {

    }

    @Override
    public void refresh() {


    }

    @Override
    public ConditionChainContext getConditionChain(String type) {
        return null;
    }
}
