package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    private String type;

    private String description;

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

    public void setDescription(String description) {
        this.description = description;
    }
}
