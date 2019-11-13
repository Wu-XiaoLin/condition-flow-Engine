package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

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
        try {
            readLock.lock();
            String collect = conditionList.stream().map(c -> c.getDescription()).collect(Collectors.joining(" ==> "));
            return collect;
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int getConditionSize() {
        return conditionSize;
    }

    @Override
    public Condition getCondition(int index) {
        return conditionList.get(index);
    }

    @Override
    public Iterator<Condition> iterator() {
        check();
        return conditionList.iterator();
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
