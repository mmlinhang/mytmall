package mytmall.controller;

import mytmall.pojo.*;
import mytmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ForeController
{
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("fore_home")
    public ModelAndView home()
    {
        List<Category> cs = categoryService.list(null);
        productService.setProductsForCategorys(cs);
        productService.setProductsByRowsForCategorys(cs);
        for(Category c:cs)
        {
            List<Product> ps = c.getProducts();
            productService.setFirstPidForProducts(ps);
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("fore/home");
        mv.addObject("cs", cs);

        return mv;
    }

    @RequestMapping("fore_register")
    public String register(Model model, User user)
    {
        String userName = user.getUserName();
        if(!userService.isExists(userName))
        {
            user.setUserName(HtmlUtils.htmlEscape(userName));
            userService.add(user);
            return "redirect:registerSuccessPage";
        }
        else
        {
            String msg = "用户名已存在";
            model.addAttribute("msg", msg);
            return "fore/register";
        }
    }

    @RequestMapping("fore_login")
    public String login(Model model, User user, HttpSession session)
    {
        String oUserName = user.getUserName();
        user.setUserName(HtmlUtils.htmlEscape(oUserName));

        User userInStore = userService.getByUserNameAndPassword(user.getUserName(), user.getPassword());
        if(userInStore != null)
        {
            session.setAttribute("user", user);
            return "redirect:/";
        }
        else
        {
            String msg = "用户名或密码错误";
            model.addAttribute("msg", msg);
            return "fore/login";
        }
    }

    @RequestMapping("fore_logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");

        return "redirect:fore_home";
    }

    @RequestMapping("fore_product")
    public ModelAndView productPage(int productId)
    {
        Product p = productService.get(productId);
        int pid = p.getId();
        p.setSingelPids(pictureService.getSinglePids(pid));
        p.setDetailPids(pictureService.getDetailPids(pid));
        p.setFirstPid(pictureService.getFirstPid(pid));

        List<Review> rs = reviewService.getReviewsForProduct(p.getId());
        for(Review r:rs)
            userService.setAnonyName(r.getUser());

        List<PropertyValue> pvs = propertyValueService.getByProductId(productId);
        for(PropertyValue pv:pvs)
        {
            int propertyId = pv.getPropertyId();
            Property property = propertyService.get(propertyId);
            pv.setProperty(property);
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("fore/product");
        mv.addObject("p", p);
        mv.addObject("rs", rs);

        return mv;
    }

    @RequestMapping("fore_checkLogin")
    @ResponseBody
    public String checkLogin(HttpSession session)
    {
        User user = (User)session.getAttribute("user");
        if(user==null)
            return "failed";
        else
            return "success";
    }

    @RequestMapping("fore_loginAjax")
    @ResponseBody
    public String loginAjax(String name, String password, HttpSession session)
    {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.getByUserNameAndPassword(name, password);

        if(user!=null)
        {
            session.setAttribute("user", user);
            return "success";
        }
        else
            return "failed";
    }

    @RequestMapping("fore_addCart")
    @ResponseBody
    public String addCart(OrderItem oi, HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        oi.setUserId(user.getId());

        Product p = productService.get(oi.getProductId());
        float price = p.getDiscountPrice();
        oi.setTotalPrice(price*oi.getTotalNum());

        orderItemService.add(oi);

        return "success";
    }


}
