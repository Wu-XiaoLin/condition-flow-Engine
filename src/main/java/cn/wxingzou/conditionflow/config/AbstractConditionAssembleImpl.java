package cn.wxingzou.conditionflow.config;

import cn.wxingzou.conditionflow.util.Assert;
import cn.wxingzou.conditionflow.core.ConditionChainContext;
import cn.wxingzou.conditionflow.util.ConditionChainContextCovertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 抽象的条件加载实现
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:07
 **/
public abstract class AbstractConditionAssembleImpl implements ConditionAssemble, ConditionChainEngineConfig {

    private Logger logger = LoggerFactory.getLogger(AbstractConditionAssembleImpl.class);


    @Override
    public ConcurrentMap<String, ConditionChainContext> createConditionChain() {
        // 获取所有条件链配置
        List<ConditionConfig> conditionConfigs = getConditionConfigs();
        if (logger.isDebugEnabled()) {
            logger.debug("准备加载条件链配置, conditionConfigs : [{}]", conditionConfigs);
        }
        Assert.notnull(conditionConfigs, "conditionConfigs");
        //创建用于存放条件链的容器
        ConcurrentMap<String, ConditionChainContext> concurrentMap = new ConcurrentHashMap<String, ConditionChainContext>((int) (conditionConfigs.size() / 0.75F));
        //条件链配置加载核心处理逻辑，
        conditionConfigs.stream().map(c -> ConditionChainContextCovertUtil.configCovertToContext(getBeanFactory(), c))
                .filter(c -> !concurrentMap.containsKey(c.getType()))
                .forEach(ctx -> concurrentMap.put(ctx.getType(), ctx));

        if (conditionConfigs.size() > concurrentMap.size()) {
            logger.warn("conditionConfig size[{}] > parse size[{}] , There may be duplicate definitions \n conditionConfig: [{}]", conditionConfigs.size(), concurrentMap.size(), conditionConfigs);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("加载条件链配置处理完成, conditionChainSize : [{}]", concurrentMap.size());
        }

        return concurrentMap;
    }

}
