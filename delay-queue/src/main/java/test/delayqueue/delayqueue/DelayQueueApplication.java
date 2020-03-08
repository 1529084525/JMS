package test.delayqueue.delayqueue;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "test.delayqueue.delayqueue")
@MapperScan(value = "test.delayqueue.delayqueue.mapper")
public class DelayQueueApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DelayQueueApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DelayQueueApplication.class);
    }

}
