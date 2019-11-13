package cn.wxingzou.flowengine.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.wxingzou.flowengine.base.ConditionChainContext;
import cn.wxingzou.flowengine.base.ConditionChainContextImpl;
import cn.wxingzou.flowengine.base.Condition;
import cn.wxingzou.flowengine.config.ConditionConfig;
import org.springframework.beans.factory.BeanFactory;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 15:30
 **/
public class ConditionChainContextUtil {


    public static ConditionChainContext configCovertToContext(BeanFactory beanFactory, ConditionConfig conditionConfig) {
        Assert.notnull(conditionConfig, "conditionConfig");
        Assert.notEmpty(conditionConfig.getType(), "conditionConfig.type");
        Assert.notEmpty(conditionConfig.getDescription(), "conditionConfig.description");
        Assert.notEmpty(conditionConfig.getChainDefinition(), "conditionConfig.chainDefinition");
        String chainDefinition = conditionConfig.getChainDefinition();
        JSONArray chainDefinitionArray = JSONUtil.parseArray(chainDefinition);
        Assert.notTrue(chainDefinitionArray.isEmpty(), "conditionConfig.chainDefinition cannot be empty");


        ConditionChainContextImpl context = new ConditionChainContextImpl();
        context.setType(conditionConfig.getType());
        context.setDescription(conditionConfig.getDescription());
        chainDefinitionArray.stream().map(c -> String.valueOf(c))
                .forEach(c -> context.addCondition(beanFactory.getBean(c, Condition.class)));
        Assert.notTrue(context.getConditionSize() <= 0, " ConditionChainContext has zero condition , parse error OR not obtained condition bean !");
        return context;
    }


}
