package cn.wxingzou.conditionflow.result;

/**
 * 执行结果
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/10 11:05
 */
public interface Result<S, F> {

    /**
     * 是否成功
     * @return
     */
    boolean isSuccess();

    /**
     * 成功结果
     * @return
     */
    S getResult();

    /**
     * 失败原因
     * @return
     */
    FailReason<F> getFailReason();

}
