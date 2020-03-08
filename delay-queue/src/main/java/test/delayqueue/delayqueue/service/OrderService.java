package test.delayqueue.delayqueue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import test.delayqueue.delayqueue.pojo.Order;

import java.util.List;

/**
 * @author ZhiXiang
 * @date 2020/3/6 10:08
 */
public interface OrderService extends IService<Order> {
    /**
     *  添加订单
     * */
    boolean addToOrder(Order order);

    /**
     * 获取未完成的订单
     * @return  数据
     */
    List<Order> getToOrderByExpire();

    /**
     * 修改过期订单状态 --> 自动取消
     * @return
     */
    boolean updateToOrderByExpire(int id, int status);
}
