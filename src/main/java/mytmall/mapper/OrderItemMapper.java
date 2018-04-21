package mytmall.mapper;

import mytmall.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper
{
    List<OrderItem> getOrderItemsByOrderId(int orderId);
    void add(OrderItem oi);
}
