package cn.wxingzou.flowengine;

import cn.wxingzou.flowengine.base.ConfigableFlowTemplate;
import cn.wxingzou.flowengine.base.FlowTemplate;
import cn.wxingzou.flowengine.config.ConditionConfig;
import cn.wxingzou.flowengine.result.Result;
import cn.wxingzou.flowengine.result.ResultHandler;
import cn.wxingzou.groupbooking.FailReasonDTO;
import cn.wxingzou.groupbooking.User;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(value = "cn.wxingzou.groupbooking")
})
public class GroupbookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupbookingApplication.class, args);
    }


}

@Component
class Runner implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) {
        List<ConditionConfig> conditionConfigs = new ArrayList<>();
        ConditionConfig conditionConfig = new ConditionConfig("totalPeople", "[\"amountGroupCondition\"]", "chain 1");
        conditionConfigs.add(conditionConfig);

        FlowTemplate<User, String, FailReasonDTO> flowTemplate = new ConfigableFlowTemplate(conditionConfigs, applicationContext);

        System.out.println(System.currentTimeMillis());

        flowTemplate.execute("totalPeople", new User(1L, "wxl"), new ResultHandler<String, FailReasonDTO>() {
            @Override
            public void handle(Result<String, FailReasonDTO> result) {
                if (result.isSuccess()) {
                    System.out.println(result.getResult());
                } else {
                    System.out.println(result.getFailReason());
                }
                System.out.println("over over");
            }
        });
        System.out.println(System.currentTimeMillis());

        System.out.println();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
