package cn.wxingzou.flowengine.base;

import cn.wxingzou.flowengine.result.ResultHandler;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:25
 **/
public interface FlowTemplate<P,S,F> {

    void execute(String type,P param, ResultHandler<S,F> resultHandler);

}
