package cn.wxingzou.groupbooking.base;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/8 16:25
 **/
public interface FlowTemplate {

    void execute(String type);

    int getConditionContextSize();

    void refresh(List<? extends ConditionConfig> conditionConfigs);

}
