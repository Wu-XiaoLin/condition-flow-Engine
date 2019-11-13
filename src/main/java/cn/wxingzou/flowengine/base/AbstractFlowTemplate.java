package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.config.ConditionConfig;
import cn.wxingzou.flowengine.result.Result;
import cn.wxingzou.flowengine.result.ResultHandler;
import org.springframework.beans.factory.BeanFactory;

import java.util.Iterator;
import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 13:43
 **/
public abstract class AbstractFlowTemplate<P, S, F> extends ConfigableConditionChainOwner implements FlowTemplate<P, S, F> {


    public AbstractFlowTemplate(List<ConditionConfig> conditionConfigs, BeanFactory beanFactory) {
        super(conditionConfigs, beanFactory);
    }

    @Override
    public void execute(String type, P param, ResultHandler<S, F> resultHandler) {
        ConditionChainContext conditionChainCtx = getConditionChain(type);
        if (conditionChainCtx == null) {
            throw new IllegalStateException("condition chain not found");
        }
        Iterator<Condition> iterator = conditionChainCtx.iterator();
        Result<S, F> result = null;
        Object successResult = param;
        Condition curr = null;
        while (iterator.hasNext()) {
            curr = iterator.next();
            result = curr.check(successResult);
            if (!result.isSuccess()) {
                break;
            }
            successResult = result.getResult();
        }
        resultHandler.handle(result);
    }
}
