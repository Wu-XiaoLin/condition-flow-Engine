package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.allocation.ConditionAssembleImpl;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 17:56
 **/
public class FlowExecuteContextImpl extends ConditionAssembleImpl implements FlowExecuteContext {
    @Override
    public void execute(String type) {

    }

    @Override
    public int getConditionContextSize() {
        return conutConditionChainSize();
    }

    @Override
    public void refresh(List<? extends ConditionConfig> conditionConfigs) {

    }
}
