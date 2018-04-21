package mytmall.controller;

import mytmall.pojo.Category;
import mytmall.pojo.Product;
import mytmall.pojo.Property;
import mytmall.service.*;
import mytmall.util.Page;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private PropertyService propertyService;

    @RequestMapping("admin_product_list")
    public ModelAndView list(Page page, int cid)
    {
        Category c = categoryService.find(cid);

        page.setTotal(productService.total(cid));
        page.setParam(String.format("&cid=%d", cid));

        List<Product> ps = productService.list(cid, page.getStart(), page.getCount());
        productService.setFirstPidForProducts(ps);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listProduct");
        mv.addObject("c", c);
        mv.addObject("page", page);
        mv.addObject("ps", ps);

        return mv;
    }

    @RequestMapping("admin_product_add")
    public String add(Product p)
    {
        Date now = new Date();
        p.setCreateDate(now);
        productService.add(p);

        int cid = p.getCid();
        List<Property> ps = propertyService.list(cid, 0, propertyService.count(cid));
        propertyValueService.addWithNewProduct(p.getId(), ps);

        return String.format("redirect:admin_product_list?cid=%d", p.getCid());
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id, int cid)
    {
        productService.delete(id);

        return "redirect:admin_product_list?cid="+cid;
    }

    @RequestMapping("admin_product_editPage")
    public ModelAndView editPage(int id)
    {
        Product p = productService.get(id);
        p.setCategory(categoryService.find(p.getCid()));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editProductPage");
        mv.addObject("p",p);

        return mv;
    }

    @RequestMapping("admin_product_edit")
    public String edit(Product p)
    {
        productService.update(p);

        return "redirect:admin_product_list?cid="+p.getCid();
    }

    @RequestMapping("admin_product_imagePage")
    public ModelAndView adminImagePage(int pid)
    {
        Product p = productService.get(pid);
        p.setSingelPids(pictureService.getSinglePids(pid));
        p.setDetailPids(pictureService.getDetailPids(pid));
        p.setCategory(categoryService.find(p.getCid()));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/adminImage");
        mv.addObject("p", p);

        return mv;
    }

}
