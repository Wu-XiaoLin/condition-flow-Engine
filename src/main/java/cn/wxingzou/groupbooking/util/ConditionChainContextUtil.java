package cn.wxingzou.groupbooking.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.wxingzou.groupbooking.allocation.ConditionChainContext;
import cn.wxingzou.groupbooking.allocation.ConditionChainContextImpl;
import cn.wxingzou.groupbooking.base.Condition;
import cn.wxingzou.groupbooking.base.ConditionConfig;
import org.springframework.context.ApplicationContext;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 15:30
 **/
public class ConditionChainContextUtil {


    public static ConditionChainContext configCovertToContext(ApplicationContext applicationContext, ConditionConfig conditionConfig) {
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
                .forEach(c -> context.addCondition(applicationContext.getBean(c, Condition.class)));
        Assert.notTrue(context.getConditionSize() <= 0, " ConditionChainContext has zero condition , parse error OR not obtained condition bean !");
        return context;
    }


}
