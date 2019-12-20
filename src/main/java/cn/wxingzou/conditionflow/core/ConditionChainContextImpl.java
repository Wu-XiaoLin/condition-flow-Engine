package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 13:20
 */
public class ConditionChainContextImpl implements ConditionChainContext {

    /**
     * 条件存放
     */
    private List<Condition> conditionList = new ArrayList<>();
    /**
     * 条件链类型 or 名称
     */
    private String type;
    /**
     * 简介
     */
    private String description;
    /**
     * 条件链对应全局参数 <b>只读</b>
     */
    private Map<String, Object> properties;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getConditionChainStr() {
        check();
        return conditionList.stream().map(Condition::getDescription).collect(Collectors.joining(" ==> "));
    }

    @Override
    public int getConditionSize() {
        return conditionList.size();
    }

    @Override
    public Condition getCondition(int index) {
        return conditionList.get(index);
    }

    @Override
    public Iterator<Condition> iterator() {
        return conditionList.iterator();
    }

    private void check() {
        if (conditionList.isEmpty()) {
            throw new IllegalStateException("conditions cannot be null");
        }
    }

    @Override
    public void addCondition(Condition condition) {
        Assert.notnull(condition, "condition");
        conditionList.add(condition);
    }

    @Override
    public String getConditionChainDescription() {
        return description;
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        //次数将map设置为只读的
        this.properties = properties == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(properties);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
