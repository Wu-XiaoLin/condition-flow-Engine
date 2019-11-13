package cn.wxingzou.flowengine.result;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/10 11:05
 */
public interface Result<S, F> {

    boolean isSuccess();

    S getResult();

    FailReason<F> getFailReason();

}
