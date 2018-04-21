package mytmall.service;

import mytmall.pojo.Category;
import java.util.List;

import mytmall.pojo.Product;
import mytmall.util.Page;

public interface CategoryService
{
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
    Category find(int id);
    void update(Category c);

    void setCategoryForProduct(Product p);
}
