package test.delayqueue.delayqueue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import test.delayqueue.delayqueue.pojo.Order;

/**
 * @author ZhiXiang
 * @date 2020/3/6 10:06
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 修改过期订单状态 --> 自动取消
     * @return
     */
    boolean updateToOrderByExpire(@Param("id") int id, @Param("status") int status);
}
