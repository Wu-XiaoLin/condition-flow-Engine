package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.ConditionConfig;
import org.springframework.beans.factory.BeanFactory;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 17:48
 **/
public interface ConditionChainEngineConfig {

   List<ConditionConfig> getConditionConfigs();

   BeanFactory getBeanFactory();

}
