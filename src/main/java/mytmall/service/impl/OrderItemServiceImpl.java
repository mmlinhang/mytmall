package mytmall.service.impl;

import mytmall.mapper.OrderItemMapper;
import mytmall.pojo.Order;
import mytmall.pojo.OrderItem;
import mytmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService
{
    @Autowired
    private OrderItemMapper orderItemMapper;

    public void setOrderItemsForOrder(Order order)
    {
        List<OrderItem> ois =
                orderItemMapper.getOrderItemsByOrderId(order.getId());
        order.setOis(ois);
    }

    public void setOrderItemsForOrders(List<Order> os)
    {
        for(Order o:os)
            setOrderItemsForOrder(o);
    }

    @Override
    public void add(OrderItem oi) {
        orderItemMapper.add(oi);
    }
}
