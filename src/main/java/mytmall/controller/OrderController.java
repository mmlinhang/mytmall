package mytmall.controller;

import mytmall.pojo.*;
import mytmall.service.*;
import mytmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController
{
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;

    @RequestMapping("admin_order_list")
    public ModelAndView list(Page page)
    {
        page.setTotal(orderService.total());

        List<Order> os = orderService.list(page);
        orderItemService.setOrderItemsForOrders(os);
        for(Order o:os)
        {
            productService.setProductForOrderItems(o.getOis());
            for(OrderItem oi:o.getOis())
                productService.setFirstPidForProduct(oi.getProduct());
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listOrder");
        mv.addObject("orders", os);
        mv.addObject("page", page);

        return mv;
    }
}
