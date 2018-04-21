package mytmall.service.impl;

import mytmall.pojo.Category;
import mytmall.pojo.Product;
import mytmall.service.CategoryService;
import java.util.List;
import mytmall.mapper.CategoryMapper;

import mytmall.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> list(Page page)
    {
        return categoryMapper.list(page);
    }

    public int total()
    {return categoryMapper.total();}

    public void add(Category category)
    {
        categoryMapper.add(category);
    }

    public void delete(int id)
    {
        categoryMapper.delete(id);
    }

    public Category find(int id)
    {
        return categoryMapper.find(id);
    }

    public void update(Category c)
    {
        categoryMapper.update(c);
    }

    @Override
    public void setCategoryForProduct(Product p)
    {
        Category c = find(p.getCid());
        p.setCategory(c);
    }
}
