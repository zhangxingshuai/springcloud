package com.receiver;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"HR_SYS_BPMS_INSTANCE_CHANGE_QUEUE_TEST_FOR_JN", "HR_SYS_BPMS_TASK_CHANGE_QUEUE_TEST_FOR_JN"})
public class Receiver {

    @RabbitHandler
    public void receive(String message){
        if (StringUtils.isNotEmpty(message)) {

            System.out.println("消费者接受到消息：" + message);
        }
    }


}
