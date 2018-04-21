package mytmall.controller;

import mytmall.service.CategoryService;

import java.util.List;
import mytmall.pojo.Category;
import mytmall.service.PropertyService;
import mytmall.util.ImageUtil;
import mytmall.util.Page;
import javax.servlet.http.HttpSession;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class CategoryController
{
    @Autowired
    private CategoryService  categoryService;
    @Autowired
    private PropertyService propertyService;

    @RequestMapping("admin_category_list")
    public ModelAndView listCategory(Page page)
    {
        //得到一页category
        List<Category> cs = categoryService.list(page);
        page.setTotal(categoryService.total());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/listCategory");
        mv.addObject("cs", cs);
        mv.addObject("page", page);

        return mv;
    }

    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, MultipartFile image)
    {
        categoryService.add(c);

        //存储图片
        File parentDir = new File(session.getServletContext().getRealPath("img/category"));
        ImageUtil.storeImage(c.getCategoryId(), image, parentDir);

        return "redirect:admin_category_list";
    }

    @RequestMapping("admin_category_delete")
    public String delete(int id, HttpSession session)
    {
        categoryService.delete(id);

        //删除图片
        String parentPath = session.getServletContext().getRealPath("img/category");
        String imagePath = id+".jpg";
        ImageUtil.deleteImage(parentPath, imagePath);

        return "redirect:admin_category_list";
    }

    @RequestMapping("admin_category_editPage")
    public ModelAndView editPage(int id)
    {
        Category c = categoryService.find(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/editCategoryPage");
        mv.addObject("c", c);

        return mv;
    }

    @RequestMapping("admin_category_edit")
    public String edit(Category c, MultipartFile image, HttpSession session)
    {
        categoryService.update(c);

        //更新图片
        if(image!=null && !image.isEmpty())
        {
            File parentDir = new File(session.getServletContext().getRealPath("img/category"));
            ImageUtil.storeImage(c.getCategoryId(), image, parentDir);
        }

        return "redirect:admin_category_list";
    }
}
