package mytmall.service;

import mytmall.pojo.Order;
import mytmall.pojo.OrderItem;

import java.util.List;

public interface OrderItemService
{
    void setOrderItemsForOrder(Order order);
    void setOrderItemsForOrders(List<Order> os);
    void add(OrderItem oi);
}
