package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.Condition;
import cn.wxingzou.groupbooking.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/9 13:20
 */
public class ConditionChainContextImpl implements ConditionChainContext {


    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private List<Condition> conditionList = new ArrayList<>();

    private int conditionSize;

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
        StringJoiner descriptionJoiner = new StringJoiner("==>");
        try {
            readLock.lock();
            int inx = 0;
            Condition condition = conditionList.get(inx);
            do {
                descriptionJoiner.add(condition.getDescription());
            } while ((condition = conditionList.get(++inx)) != null);
        } finally {
            readLock.unlock();
        }
        return descriptionJoiner.toString();
    }

    @Override
    public int getConditionSize() {
        return conditionSize;
    }

    public void check() {
        if (conditionList.isEmpty()) {
            throw new IllegalStateException("conditions cannot be null");
        }
    }

    @Override
    public void addCondition(Condition condition) {
        Assert.notnull(condition, "condition");
        try {
            writeLock.lock();
            conditionList.add(condition);
            conditionSize++;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String getConditionChainDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
