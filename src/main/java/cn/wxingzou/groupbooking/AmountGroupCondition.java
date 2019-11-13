package cn.wxingzou.groupbooking;

import cn.wxingzou.flowengine.base.Condition;
import cn.wxingzou.flowengine.result.Result;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 16:42
 **/
@Component
public class AmountGroupCondition implements Condition<User> {

    @Override
    public Result<String, String> check(User user) {
        if (user.getId().equals(Long.valueOf(1))) {
            return ResultDTO.getBuild().success(user.getUserName()).build();
        }
        return ResultDTO.getBuild().fail(FailReasonDTO.AMOUNT_GROUP_OVERSTEP).build();
    }

    @Override
    public String getDescription() {
        return "账户拼团数量条件";
    }
}
