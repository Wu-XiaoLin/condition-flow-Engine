package cn.wxingzou.flowengine.result;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:44
 **/
@FunctionalInterface
public interface ResultHandler<S, F> {
    void handle(Result<S, F> result);
}
