package cn.wxingzou.conditionflow.config;

import cn.wxingzou.conditionflow.core.BeanFactory;

import java.util.List;

/**
 * 抽象条件链创建配置接口
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 17:48
 **/
public interface ConditionChainEngineConfig {

   /**
    * 获取多个条件链配置 ，用于加载条件链引擎
    * @return
    */
   List<ConditionConfig> getConditionConfigs();

   /**
    * 获取抽象的bean对象工厂，用于获取 条件bean，可以根据情况实现 #{@link BeanFactory}
    * @return
    */
   BeanFactory getBeanFactory();

}
