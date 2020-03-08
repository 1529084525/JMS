package test.delayqueue.delayqueue.delay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhiXiang
 * @date 2020/3/6 14:19
 */
@Configuration
public class TreadPoolConfig {

    @Bean
    public ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(10);
    }
}
