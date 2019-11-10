package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.Condition;

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
public abstract class AbstractConditionChainContext implements ConditionChainContext {


    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private List<Condition> conditionList = new ArrayList<>();

    private int conditionSize;

    @Override
    public String getConditionChainDescription() {
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
        try {
            writeLock.lock();
            conditionList.add(condition);
            conditionSize++;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void reset() {
        try {
            writeLock.lock();
            conditionList.clear();
            conditionSize = 0;
        } finally {
            writeLock.unlock();
        }
    }
}
