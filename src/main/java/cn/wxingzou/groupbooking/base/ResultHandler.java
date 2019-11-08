package cn.wxingzou.groupbooking.base;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:44
 **/
public interface ResultHandler<R> {

    R success();

    R fail();

}
