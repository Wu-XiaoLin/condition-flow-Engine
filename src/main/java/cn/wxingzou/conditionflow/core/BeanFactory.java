package cn.wxingzou.conditionflow.core;

/**
 * 抽象 condition 获取工厂
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 18:15
 **/
public interface BeanFactory {

    /**
     * 根据Bean名称获取对应的Bean对象
     *
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getBean(String beanName, Class<T> clazz);
}

