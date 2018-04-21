package mytmall.service;

import mytmall.pojo.Order;
import mytmall.util.Page;

import java.util.List;

public interface OrderService
{
    List<Order> list(Page page);
    int total();
}
