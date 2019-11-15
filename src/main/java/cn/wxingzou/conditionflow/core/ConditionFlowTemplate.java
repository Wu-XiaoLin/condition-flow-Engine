package cn.wxingzou.conditionflow.core;

import cn.wxingzou.conditionflow.result.Result;
import cn.wxingzou.conditionflow.result.ResultHandler;

/**
 * 条件流执行模板
 * <p>
 * 三个泛型定义分别为：
 * P : 首个条件开始的入参，若不使用可以定义为 #{@link Void},传入可以为null。
 * S ：为最终执行成功后条件链返回的结果类型，意为 SUCCESS。
 * F ：为执行失败返回的结果类型，意为FAIL。（此处的 泛型 F 应与 #{@link cn.wxingzou.conditionflow.result.FailReason } 定义的泛型 R 一致）
 *
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:25
 **/
public interface ConditionFlowTemplate<P, S, F> {

    /**
     * 执行type对应的条件链
     *
     * @param type          条件链类型
     * @param param         首个条件链的传入参数（后面条件链的参数取决于上一个条件返回的#{@link Result#getResult()}）
     * @param resultHandler 结果处理，可以使用 lambda 表达式处理结果
     */
    void execute(String type, P param, ResultHandler<S, F> resultHandler);

    /**
     * 执行type 对应的条件链，和上面的方法区别在于此方法会返回操作结果，在处理结果上稍有不同。
     *
     * @param type  条件链类型
     * @param param 首个条件链的传入参数（后面条件链的参数取决于上一个条件返回的#{@link Result#getResult()}）
     * @return
     */
    Result<S, F> execute(String type, P param);

}
