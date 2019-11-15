package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.config.ConditionConfig;

import java.util.List;

/**
 * 可配置的条件链模板，使用此类进行初始化并开始使用
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 17:28
 **/
public class ConfigableConditionFlowTemplate extends AbstractConditionFlowTemplate {

    public ConfigableConditionFlowTemplate(List<ConditionConfig> conditionConfigs, BeanFactory beanFactory) {
        super(conditionConfigs, beanFactory);
    }

}
