package cn.wxingzou.conditionflow.result;

/**
 * 结果处理
 * <p>
 * 泛型解释
 * S : 成功返回结果类型
 * F : 失败原因包装类型 （对应 #{@link FailReason }的 泛型 R ）
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:44
 **/
@FunctionalInterface
public interface ResultHandler<S, F> {

    void handle(Result<S, F> result);
}
