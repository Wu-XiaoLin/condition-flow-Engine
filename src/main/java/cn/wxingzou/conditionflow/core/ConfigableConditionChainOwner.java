package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.util.Assert;
import cn.wxingzou.conditionflow.config.ConditionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 可配置的条件链所有者
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 11:05
 **/
public class ConfigableConditionChainOwner extends AbstractConfigableConditionChainOwner {

    private Logger logger = LoggerFactory.getLogger(ConfigableConditionChainOwner.class);

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
        logger.info("ConditionChain Flow Engine Initialize Success.");
    }
}
