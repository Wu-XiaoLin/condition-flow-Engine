package cn.wxingzou.conditionflow.config;

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

    @Override
    public String toString() {
        return "ConditionConfig{" +
                "type='" + type + '\'' +
                ", chainDefinition='" + chainDefinition + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
