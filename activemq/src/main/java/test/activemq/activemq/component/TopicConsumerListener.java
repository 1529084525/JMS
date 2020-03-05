package test.activemq.activemq.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author ZhiXiang
 * @create 2020/3/4 11:08
 */
@Component
public class TopicConsumerListener {

    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory =  "topicListener")
    public void readActiveTopic(String message) {
        System.out.println("接收到Topic : " + message);
    }
}
