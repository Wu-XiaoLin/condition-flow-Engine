package cn.wxingzou.groupbooking;

import cn.wxingzou.flowengine.result.FailReason;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 16:42
 **/
public class FailReasonImpl<T> implements FailReason<T> {

    private T reason;

    public FailReasonImpl(T reason) {
        this.reason = reason;
    }

    @Override
    public T getReason() {
        return reason;
    }

    public void setReason(T reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "FailReasonImpl{" +
                "reason=" + reason +
                '}';
    }
}
