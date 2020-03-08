package test.delayqueue.delayqueue.delay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.delayqueue.delayqueue.pojo.Order;
import test.delayqueue.delayqueue.service.OrderService;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;

/**
 * @author ZhiXiang
 * @date 2020/3/6 9:47
 */
@Slf4j
@Component
public class DelayOrderImpl<T> implements DelayOrder<Order> {

    private final static DelayQueue<ItemDelayed<Order>> DELAY_QUEUE = new DelayQueue<>();

    @Autowired
    private OrderService orderService;

    @Autowired
    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        log.info("系统初始化中*******     自动扫描订单等待状态");
        List<Order> toOrderByExpire = orderService.getToOrderByExpire();
        for (Order order : toOrderByExpire) {
            ItemDelayed<Order> itemDelayed = new ItemDelayed<>(order.getId().longValue(), order.getPayTime().getTime());
            this.addToItemDelayed(itemDelayed);
        }
        log.info("系统初始化完成******** 扫描到{}个订单, 准备进行过期检查", toOrderByExpire.size());

        executorService.execute(() -> {
            log.info("启动处理的订单线程: " + Thread.currentThread().getName());
            ItemDelayed<Order> itemDelayed;
            while (true) {
                try {
                    itemDelayed = DELAY_QUEUE.take();
                    //自动处理超时订单 修改状态
                    boolean expire = orderService.updateToOrderByExpire(Math.toIntExact(itemDelayed.getDataId()), 4);
                    log.info("修改状态： " + expire);
                } catch (InterruptedException e) {
                    log.error("执行订单延迟队列处理失败 : " + e);
                }
            }
        });
    }

    @Override
    public boolean addToDelayQueue(Order order) {
        return DELAY_QUEUE.add(new ItemDelayed<Order>(order.getId().longValue(), order.getPayTime().getTime()));
    }

    @Override
    public boolean removeToDelayQueue(Order order) {
        if (order == null) {
            return false;
        }
        for (Iterator<ItemDelayed<Order>> iterator = DELAY_QUEUE.iterator(); iterator.hasNext(); ) {
            ItemDelayed<Order> queue = iterator.next();
            if(queue.getDataId().equals(order.getId())) {
                DELAY_QUEUE.remove(order);
            }
        }
        return false;
    }

    @Override
    public boolean addToItemDelayed(ItemDelayed<Order> itemDelayed) {
        return DELAY_QUEUE.add(itemDelayed);
    }
}
