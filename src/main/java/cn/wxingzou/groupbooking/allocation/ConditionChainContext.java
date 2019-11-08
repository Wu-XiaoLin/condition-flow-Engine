package cn.wxingzou.groupbooking.allocation;

import cn.wxingzou.groupbooking.base.GroupBookingCondition;

import java.util.StringJoiner;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:10
 **/
public class ConditionChainContext {

    private GroupBookingCondition first;

    public String getConditionChainDescription() {
        check();
        GroupBookingCondition condition = first;
        StringJoiner descriptionJoiner = new StringJoiner("==>");
        do {
            descriptionJoiner.add(condition.getDescription());
        } while ((condition = condition.getNextCondition()) != null);
        return descriptionJoiner.toString();
    }


    public int getConditionSize() {
        check();
        GroupBookingCondition condition = first;
        int conditionSize = 1;
        while (true) {
            if (null != condition.getNextCondition()) {
                conditionSize++;
            } else {
                break;
            }
        }
        return conditionSize;
    }

    public void check() {
        if (first == null) {
            throw new IllegalStateException("first condition cannot be null");
        }
    }

    public GroupBookingCondition getFirst() {
        return first;
    }

    public void setFirst(GroupBookingCondition first) {
        this.first = first;
    }
}
