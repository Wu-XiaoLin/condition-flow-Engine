package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.ConditionConfig;
import cn.wxingzou.groupbooking.util.Assert;
import cn.wxingzou.groupbooking.util.ConditionChainContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:07
 **/
public class ConditionAssembleImpl implements ConditionAssemble {

    private static Logger logger = LoggerFactory.getLogger(ConditionAssembleImpl.class);

    private ConcurrentMap<String, ConditionChainContext> concurrentMap = new ConcurrentHashMap();

    private ApplicationContext context;

    @Override
    public boolean createConditionChain(List<? extends ConditionConfig> conditionConfigs) {
        Assert.notnull(conditionConfigs, "conditionConfigs");

        conditionConfigs.stream().map(c -> ConditionChainContextUtil.configCovertToContext(context, c))
                .filter(c -> !concurrentMap.containsKey(c.getType()))
                .forEach(ctx -> concurrentMap.put(ctx.getType(), ctx));

        if (conditionConfigs.size() > concurrentMap.size()) {
            logger.warn("conditionConfig size[{}] > parse size[{}] , There may be duplicate definitions \n conditionConfig: [{}]", conditionConfigs.size(), concurrentMap.size(), conditionConfigs);
        }

        return true;
    }

    @Override
    public int conutConditionChainSize() {
        return concurrentMap.size();
    }
}
