package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.config.AbstractConditionAssembleImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/12 17:24
 **/
public abstract class AbstractConfigableConditionChainOwner extends AbstractConditionAssembleImpl implements ConfigutableConditionChainOwner {

    private static Logger logger = LoggerFactory.getLogger(AbstractConfigableConditionChainOwner.class);

    private ConcurrentMap<String, ConditionChainContext> concurrentMap = new ConcurrentHashMap();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    @Override
    public ConditionChainContext getConditionChain(String type) {
        try {
            readLock.lock();
            return concurrentMap.get(type);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void setConditionChainMap() {
        try {
            writeLock.lock();
            concurrentMap = createConditionChain();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void reset() {
        try {
            writeLock.lock();
            concurrentMap.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
