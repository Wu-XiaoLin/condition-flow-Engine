package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.allocation.ConditionChainContext;
import org.springframework.beans.factory.BeanFactory;

import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 11:51
 **/
public interface ConditionChainOwner {

    ConditionChainContext getConditionChain(String type);

    void setConditionChainMap(ConcurrentMap<String,ConditionChainContext> contextConcurrentMap);

    void reset();
}
