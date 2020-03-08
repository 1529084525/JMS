package test.delayqueue.delayqueue.delay;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhiXiang
 * @date 2020/3/6 9:29
 */
@Data
public class ItemDelayed<T> implements Delayed {

    /**
     * 默认延迟时间
     */
    private final static Long DELAY = 30 * 60 * 1000L;

    /**
     * 数据ID
     */
    private Long dataId;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 创建时间
     */
    private Date now;

    /**
     * 数据
     */
    private T data;

    public ItemDelayed(Long dataId, Long startTime) {
        this.dataId = dataId;
        this.startTime = startTime;
        this.endTime = startTime + DELAY;
        this.now = new Date();
    }

    public ItemDelayed(Long dataId, Long startTime, Long endTime) {
        this.dataId = dataId;
        this.startTime = startTime;
        this.endTime = startTime + (endTime * 10000);
        this.now = new Date();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.endTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
