package test.delayqueue.delayqueue.delay;

/**
 * @author ZhiXiang
 * @date 2020/3/6 9:43
 */
public interface DelayOrder<T> {

    /**
     * 添加对象到延迟队列
     * @param data  数据
     * @return  boolean
     */
    boolean addToDelayQueue(T data);

    /**
     * 从延迟队列中移除对象
     * @param date  数据
     * @return  boolean
     */
    boolean removeToDelayQueue(T date);

    /**
     * 添加延迟对象到延迟队列
     * @param itemDelayed   延迟对象
     * @return  boolean
     */
    boolean addToItemDelayed(ItemDelayed<T> itemDelayed);

}
