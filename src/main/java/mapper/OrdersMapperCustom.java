package mapper;

import po.Orders;
import po.OrdersCustom;

import java.util.List;

/**
 * @author OneCallAway
 * @create 2018-03-28 下午2:36
 * @desc 订单的mapper
 **/


public interface OrdersMapperCustom {
    //查询关联用户信息
    public List<OrdersCustom> findOrdersUser() throws Exception;

    //查询关联用户信息resultMap
    public List<Orders> findOrdersUserResultMap() throws Exception;

    //查询订单(关联用户)以及订单明细
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
}
