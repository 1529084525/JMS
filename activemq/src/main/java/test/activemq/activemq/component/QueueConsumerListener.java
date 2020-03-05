package test.activemq.activemq.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author ZhiXiang
 * @create 2020/3/4 11:06
 */
@Component
public class QueueConsumerListener {

    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接收到： " + message);
    }
}
