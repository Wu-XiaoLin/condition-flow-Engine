package cn.wxingzou.flowengine.base;

import cn.hutool.core.collection.CollUtil;
import cn.wxingzou.flowengine.config.ConditionConfig;
import cn.wxingzou.flowengine.util.Assert;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 17:28
 **/
public class ConfigableFlowTemplate extends AbstractFlowTemplate {
    public ConfigableFlowTemplate(List<ConditionConfig> conditionConfigs, BeanFactory beanFactory) {
        super(conditionConfigs, beanFactory);
    }
}
