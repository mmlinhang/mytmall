package mytmall.controller;

import mytmall.pojo.User;
import mytmall.service.UserService;
import mytmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("admin_user_list")
    public ModelAndView list(Page page)
    {
        List<User> users = userService.list(page);

        page.setTotal(userService.total());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listUser");
        mv.addObject("users", users);
        mv.addObject("page", page);

        return mv;
    }
}
