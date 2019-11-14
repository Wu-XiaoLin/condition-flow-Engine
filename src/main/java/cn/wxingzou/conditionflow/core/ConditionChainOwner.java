package cn.wxingzou.conditionflow.core;

/**
 * 条件链所有者
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 11:51
 **/
public interface ConditionChainOwner {

    /**
     * 根据类型获取对应的条件链上下文
     * @param type
     * @return
     */
    ConditionChainContext getConditionChain(String type);

    /**
     * 设置条件链对象
     */
    void setConditionChainMap();

    /**
     * 初始化
     */
    void init();

}
