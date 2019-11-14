package cn.wxingzou.conditionflow.util;

import cn.wxingzou.conditionflow.config.ConditionConfig;
import cn.wxingzou.conditionflow.core.BeanFactory;
import cn.wxingzou.conditionflow.core.Condition;
import cn.wxingzou.conditionflow.core.ConditionChainContext;
import cn.wxingzou.conditionflow.core.ConditionChainContextImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 条件链配置转换工具
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 15:30
 **/
public class ConditionChainContextCovertUtil {

    private static Logger logger = LoggerFactory.getLogger(ConditionChainContextCovertUtil.class);

    public static ConditionChainContext configCovertToContext(BeanFactory beanFactory, ConditionConfig conditionConfig) {
        Assert.notnull(conditionConfig, "conditionConfig");
        Assert.notEmpty(conditionConfig.getType(), "conditionConfig.type");
        Assert.notEmpty(conditionConfig.getDescription(), "conditionConfig.description");
        Assert.notEmpty(conditionConfig.getChainDefinition(), "conditionConfig.chainDefinition");
        if (logger.isDebugEnabled()) {
            logger.debug("准备加载条件链: [{}],[{}]", conditionConfig.getType(), conditionConfig.getDescription());
        }
        try {
            //条件链定义转为json数组
            JSONArray chainDefinitionArray = JSON.parseArray(conditionConfig.getChainDefinition());
            Assert.notTrue(chainDefinitionArray.isEmpty(), "conditionConfig.chainDefinition cannot be empty");
            ConditionChainContextImpl context = new ConditionChainContextImpl();
            context.setType(conditionConfig.getType());
            context.setDescription(conditionConfig.getDescription());
            chainDefinitionArray.stream().map(String::valueOf)
                    .forEach(c -> context.addCondition(beanFactory.getBean(c, Condition.class)));
            Assert.notTrue(context.getConditionSize() <= 0, " ConditionChainContext has zero condition , parse error OR not obtained condition bean !");
            return context;
        } catch (Exception e) {
            logger.error("条件链加载失败: [{}],[{}]", conditionConfig.getType(), conditionConfig.getDescription());
            throw e;
        }
    }


}
