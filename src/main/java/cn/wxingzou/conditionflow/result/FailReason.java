package cn.wxingzou.conditionflow.result;

/**
 * 失败原因
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 17:36
 **/
public interface FailReason<R> {

    R getReason();

}
