package cn.wxingzou.groupbooking.base;

import cn.wxingzou.groupbooking.result.FailReason;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:39
 **/
public interface GroupBookingCondition {

    boolean check();

    default GroupBookingCondition getNextCondition() {
        return null;
    }

    FailReason fail();

    String getDescription();

}
