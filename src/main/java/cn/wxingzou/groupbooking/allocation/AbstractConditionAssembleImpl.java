package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.ConditionConfig;
import cn.wxingzou.groupbooking.util.Assert;
import cn.wxingzou.groupbooking.util.ConditionChainContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:07
 **/
public abstract class AbstractConditionAssembleImpl implements ConditionAssemble, ConditionChainEngineConfig {

    private static Logger logger = LoggerFactory.getLogger(AbstractConditionAssembleImpl.class);


    @Override
    public ConcurrentMap<String, ConditionChainContext> createConditionChain() {
        List<ConditionConfig> conditionConfigs = getConditionConfigs();
        Assert.notnull(conditionConfigs, "conditionConfigs");

        ConcurrentMap<String, ConditionChainContext> concurrentMap = new ConcurrentHashMap();
        conditionConfigs.stream().map(c -> ConditionChainContextUtil.configCovertToContext(getBeanFactory(), c))
                .filter(c -> !concurrentMap.containsKey(c.getType()))
                .forEach(ctx -> concurrentMap.put(ctx.getType(), ctx));

        if (conditionConfigs.size() > concurrentMap.size()) {
            logger.warn("conditionConfig size[{}] > parse size[{}] , There may be duplicate definitions \n conditionConfig: [{}]", conditionConfigs.size(), concurrentMap.size(), conditionConfigs);
        }

        return concurrentMap;
    }

}
