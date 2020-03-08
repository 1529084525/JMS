package test.delayqueue.delayqueue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZhiXiang
 * @date 2020/3/6 9:56
 */
@Data
@TableName("ORDERD")
public class Order {

    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    private String name;
    private String orderD;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payTime;
    /**
     * 状态
     * 1 - 已完成
     * 2 - 已取消
     * 3 - 等待中
     * 4 - 自动取消
     */
    private Integer status;
}
