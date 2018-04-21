package mytmall.mapper;

import mytmall.pojo.Order;
import mytmall.util.Page;

import java.util.List;

public interface OrderMapper
{
    List<Order> list(Page page);
    int total();
}
