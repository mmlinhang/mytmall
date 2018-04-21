package mytmall.controller;

import mytmall.pojo.Category;
import mytmall.pojo.Product;
import mytmall.pojo.Property;
import mytmall.service.ProductService;
import mytmall.service.PropertyService;

import mytmall.service.PropertyValueService;
import mytmall.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PropertyController
{
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ProductService productService;

    @RequestMapping("admin_property_list")
    public ModelAndView list(Category c, Page page)
    {
        List<Property> ps = propertyService.list(c.getCategoryId(), page.getStart(), page.getCount());

        page.setTotal(propertyService.count(c.getCategoryId()));
        page.setParam(String.format("&categoryId=%d&categoryName=%s", c.getCategoryId(), c.getCategoryName()));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listProperty");
        mv.addObject("page", page);
        mv.addObject("c", c);
        mv.addObject("ps", ps);

        return mv;
    }

    @RequestMapping("admin_property_add")
    public String add(Category c, Property property)
    {
        int cid = c.getCategoryId();

        property.setCid(cid);
        propertyService.add(property);

        List<Product> ps = productService.list(cid, 0, productService.total(cid));
        propertyValueService.addWithNewProperty(property.getId(), ps);

        return String.format("redirect:admin_property_list?categoryId=%d&categoryName=%s", c.getCategoryId(), c.getCategoryName());
    }

    @RequestMapping("admin_property_delete")
    public String delete(Category c, int id)
    {
        propertyService.delete(id);

        return String.format("redirect:admin_property_list?categoryId=%d&categoryName=%s", c.getCategoryId(), c.getCategoryName());
    }

    @RequestMapping("admin_property_editPage")
    public ModelAndView editPage(Category c, Property p)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editPropertyPage");
        mv.addObject("c", c);
        mv.addObject("p", p);

        return mv;
    }

    @RequestMapping("admin_property_edit")
    public String edit(String categoryName, Property p)
    {
        propertyService.update(p);

        return String.format("redirect:admin_property_list?categoryId=%d&categoryName=%s", p.getCid(), categoryName);
    }
}


