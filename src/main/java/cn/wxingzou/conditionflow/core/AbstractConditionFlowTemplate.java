package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.config.ConditionConfig;
import cn.wxingzou.conditionflow.result.Result;
import cn.wxingzou.conditionflow.result.ResultHandler;
import cn.wxingzou.conditionflow.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

/**
 * 抽象实现条件流模板
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 13:43
 **/
public abstract class AbstractConditionFlowTemplate<P, S, F> extends ConfigableConditionChainOwner implements ConditionFlowTemplate<P, S, F> {

    private Logger logger = LoggerFactory.getLogger(AbstractConditionFlowTemplate.class);


    public AbstractConditionFlowTemplate(List<ConditionConfig> conditionConfigs, BeanFactory beanFactory) {
        super(conditionConfigs, beanFactory);
    }

    @Override
    public void execute(String type, P param, ResultHandler<S, F> resultHandler) {
        resultHandler.handle(doExecute(type, param));
    }

    @Override
    public Result<S, F> execute(String type, P param) {
        return doExecute(type, param);
    }

    /**
     * 实际的执行方法
     *
     * @param type
     * @param param
     * @return
     */
    private Result<S, F> doExecute(String type, P param) {
        if (logger.isDebugEnabled()) {
            logger.debug("准备获取 [{}] 对应的条件链", type);
        }
        Assert.notEmpty(type, "type");
        // 获取对应的条件链上下文对象
        ConditionChainContext conditionChainCtx = getConditionChain(type);
        if (conditionChainCtx == null) {
            throw new IllegalStateException("condition chain not found");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("[{}] 对应的条件个数为 ：[{}]", type, conditionChainCtx.getConditionSize());
        }
        //使用迭代器的形式进行条件循环
        Iterator<Condition> iterator = conditionChainCtx.iterator();
        //存放最终执行结果
        Result<S, F> result = null;
        // 每个条件的入参，首个条件入参由用户传入，后面的条件入参取决于上一个条件的返回结果中的getResult()
        Object successResult = param;

        Condition curr;
        while (iterator.hasNext()) {
            curr = iterator.next();
            result = curr.check(successResult);
            if (logger.isDebugEnabled()) {
                logger.debug("[{}] 条件链中的 [{}] 条件执行完成, 是否成功：[{}], 返回结果为：[{}]", type, curr.getDescription(), result.isSuccess(), result);
            }
            if (result.isSuccess()) {
                //准备下一个条件的入参
                successResult = result.getResult();
                continue;
            }
            //只要有一个条件的返回结果不为成功则结束执行，返回结果
            break;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("[{}] 条件链完成执行，最终结果为：[{}]", type, result != null ? result.isSuccess() : result);
        }
        return result;
    }

}
