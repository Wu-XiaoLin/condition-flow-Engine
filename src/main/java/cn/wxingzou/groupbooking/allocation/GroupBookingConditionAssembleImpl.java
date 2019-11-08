package cn.wxingzou.groupbooking.allocation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:07
 **/
public class GroupBookingConditionAssembleImpl  implements GroupBookingConditionAssemble{

    private ConcurrentMap<String,?> concurrentMap = new ConcurrentHashMap();



    @Override
    public boolean createConditionChain() {

        return false;
    }
}
