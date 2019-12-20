package cn.wxingzou.conditionflow.config;

import java.util.Map;

/**
 * 条件链配置
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/11 15:21
 **/
public class ConditionConfig {


    /**
     * 类型
     */
    private String type;
    /**
     * json数组表示,每个元素为serviceName`
     * ["condition1","condition2"]
     */
    private String chainDefinition;

    /**
     * 条件链需要的所有参数
     */
    private Map<String, Object> properties;

    /**
     * 描述
     */
    private String description;

    public ConditionConfig() {
    }

    public ConditionConfig(String type, String chainDefinition, String description) {
        this.type = type;
        this.chainDefinition = chainDefinition;
        this.description = description;
    }

    public ConditionConfig(String type, String chainDefinition, Map<String, Object> properties, String description) {
        this.type = type;
        this.chainDefinition = chainDefinition;
        this.properties = properties;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChainDefinition() {
        return chainDefinition;
    }

    public void setChainDefinition(String chainDefinition) {
        this.chainDefinition = chainDefinition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "ConditionConfig{" +
                "type='" + type + '\'' +
                ", chainDefinition='" + chainDefinition + '\'' +
                ", properties=" + properties +
                ", description='" + description + '\'' +
                '}';
    }
}
