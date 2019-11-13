package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.config.ConditionConfig;
import cn.wxingzou.flowengine.util.Assert;
import org.springframework.beans.factory.BeanFactory;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 11:05
 **/
public class ConfigableConditionChainOwner extends AbstractConfigableConditionChainOwner {

    private List<ConditionConfig> conditionConfigs;
    private BeanFactory beanFactory;

    public ConfigableConditionChainOwner(List<ConditionConfig> conditionConfigs, BeanFactory beanFactory) {
        this.conditionConfigs = conditionConfigs;
        this.beanFactory = beanFactory;
        this.init();
    }

    @Override
    public List<ConditionConfig> getConditionConfigs() {
        return conditionConfigs;
    }

    @Override
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void init() {
        Assert.notTrue((null == conditionConfigs), "conditionConfigs cannot be null");
        Assert.notnull(beanFactory, "beanFactory");
        setConditionChainMap();
    }
}
