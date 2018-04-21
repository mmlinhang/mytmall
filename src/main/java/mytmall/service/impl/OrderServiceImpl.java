package mytmall.service.impl;

import mytmall.mapper.OrderMapper;
import mytmall.pojo.Order;
import mytmall.service.OrderService;
import mytmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> list(Page page)
    {
        return orderMapper.list(page);
    }

    public int total()
    {
        return orderMapper.total();
    }


}
