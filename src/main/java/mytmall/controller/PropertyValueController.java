package mytmall.controller;

import mytmall.pojo.Product;
import mytmall.pojo.PropertyValue;
import mytmall.service.CategoryService;
import mytmall.service.ProductService;
import mytmall.service.PropertyService;
import mytmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PropertyValueController
{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyValueService propertyValueService;

    @RequestMapping("admin_propertyValue_list")
    public ModelAndView list(int productId)
    {
        Product product = productService.get(productId);
        categoryService.setCategoryForProduct(product);

        List<PropertyValue> pvs = propertyValueService.getByProductId(productId);
        propertyService.setPropertyForPropertyValues(pvs);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listPropertyValue");
        mv.addObject("pvs", pvs);
        mv.addObject("product", product);

        return mv;
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(int pvid, String value)
    {
        PropertyValue pv = propertyValueService.getByPropertyValueId(pvid);
        pv.setValue(value);
        propertyValueService.update(pv);

        return "success";
    }
}
