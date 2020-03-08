package test.delayqueue.delayqueue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.delayqueue.delayqueue.mapper.OrderMapper;
import test.delayqueue.delayqueue.pojo.Order;
import test.delayqueue.delayqueue.service.OrderService;

import java.util.List;

/**
 * @author ZhiXiang
 * @date 2020/3/6 10:09
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean addToOrder(Order order) {
        return orderMapper.insert(order) > 0;
    }

    @Override
    public List<Order> getToOrderByExpire() {
        return orderMapper.selectList(new QueryWrapper<Order>().eq("status", 3));
    }

    @Override
    public boolean updateToOrderByExpire(int id, int status) {
        return orderMapper.updateToOrderByExpire(id, status);
    }
}
